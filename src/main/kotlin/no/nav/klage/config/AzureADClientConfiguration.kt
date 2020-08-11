package no.nav.klage.config

import no.nav.klage.client.OidcDiscoveryClient
import no.nav.klage.util.getLogger
import no.nav.klage.util.getReactorClientHttpConnector
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient


@Configuration
class AzureADClientConfiguration(
        private val webClientBuilder: WebClient.Builder
) {

    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        private val logger = getLogger(javaClass.enclosingClass)
    }

    @Value("\${HTTPS_PROXY}")
    private lateinit var proxyUrl: String

    @Bean
    fun azureADWebClient(): WebClient {
        return webClientBuilder
                .clientConnector(getReactorClientHttpConnector(proxyUrl))
                .build()
    }
}