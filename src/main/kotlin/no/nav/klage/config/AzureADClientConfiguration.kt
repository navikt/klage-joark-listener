package no.nav.klage.config

import no.nav.klage.client.OidcDiscoveryClient
import no.nav.klage.util.getLogger
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient
import reactor.netty.http.client.HttpClient
import reactor.netty.tcp.ProxyProvider


@Configuration
class AzureADClientConfiguration(
        private val webClientBuilder: WebClient.Builder,
        private val oidcDiscoveryClient: OidcDiscoveryClient
) {

    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        private val logger = getLogger(javaClass.enclosingClass)
    }

    @Value("\${HTTPS_PROXY}")
    private lateinit var proxyUrl: String

    @Bean
    fun azureADWebClient(): WebClient {
        val httpClient: HttpClient = HttpClient.create()
            .tcpConfiguration { tcpClient ->
                tcpClient.proxy { proxy ->
                    proxy.type(ProxyProvider.Proxy.HTTP).host(proxyUrl)
                }
            }
        val connector = ReactorClientHttpConnector(httpClient)
        return webClientBuilder
                .baseUrl(oidcDiscoveryClient.oidcDiscovery().token_endpoint)
                .clientConnector(connector)
                .build()
    }
}
