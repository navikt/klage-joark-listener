package no.nav.klage.client

import brave.Tracer
import no.nav.klage.domain.OidcToken
import no.nav.klage.util.getLogger
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono

@Component
class StsClient(private val stsWebClient: WebClient, private val tracer: Tracer) {

    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        private val logger = getLogger(javaClass.enclosingClass)
        private var cachedOidcToken: OidcToken? = null
    }

    @Value("\${navCallId}")
    lateinit var navCallId: String

    fun oidcToken(): String {
        if (cachedOidcToken.shouldBeRenewed()) {
            logger.debug("Getting token from STS")
            cachedOidcToken = stsWebClient.get()
                .uri { uriBuilder ->
                    uriBuilder
                        .queryParam("grant_type", "client_credentials")
                        .queryParam("scope", "openid")
                        .build()
                }
                .header(navCallId, tracer.currentSpan().context().traceIdString())
                .retrieve()
                .bodyToMono<OidcToken>()
                .block()
        }

        return cachedOidcToken!!.token
    }

    private fun OidcToken?.shouldBeRenewed(): Boolean = this?.hasExpired() ?: true
}
