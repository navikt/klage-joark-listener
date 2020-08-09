package no.nav.klage.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class SafClientConfiguration(private val webClientBuilder: WebClient.Builder) {

    @Value("\${SAF_BASE_URL}")
    private lateinit var safUrl: String

    @Value("\${SAF_APIKEY}")
    private lateinit var apiKey: String

    @Value("\${spring.application.name}")
    lateinit var appName: String

    @Value("\${navConsumerId}")
    lateinit var navConsumerId: String

    @Value("\${xNavApiKey}")
    private lateinit var xNavApiKey: String

    @Bean
    fun safWebClient(): WebClient {
        return webClientBuilder
            .baseUrl(safUrl)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader(navConsumerId, appName)
            .defaultHeader(xNavApiKey, apiKey)
            .build()
    }
}
