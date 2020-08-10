package no.nav.klage.config

import no.nav.klage.client.OidcDiscoveryClient
import no.nav.klage.util.getLogger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class AzureADClientConfiguration(
        private val webClientBuilder: WebClient.Builder,
        private val oidcDiscoveryClient: OidcDiscoveryClient
) {

    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        private val logger = getLogger(javaClass.enclosingClass)
    }

    @Bean
    fun azureADWebClient(): WebClient {
        return webClientBuilder
                .baseUrl(oidcDiscoveryClient.oidcDiscovery().token_endpoint)
                .build()
    }
}