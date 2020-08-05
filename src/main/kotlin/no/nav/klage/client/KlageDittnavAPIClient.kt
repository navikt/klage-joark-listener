package no.nav.klage.client

import no.nav.klage.domain.JoarkStatus
import no.nav.klage.getLogger
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class KlageDittnavAPIClient(
        private val klageDittnavAPIWebClient: WebClient,
        private val azureADClient: AzureADClient
) {

    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        private val logger = getLogger(javaClass.enclosingClass)
    }

    fun sendJoarkStatusToKlage(journalpostId: String, joarkStatus: JoarkStatus) {
        logger.debug("Sending Joark status to klage-dittnav-api. JournalpostId: {}", journalpostId)
        klageDittnavAPIWebClient.post()
                .uri("/joarkstatus/$journalpostId")
                .header(HttpHeaders.AUTHORIZATION, "Bearer ${azureADClient.oidcToken()}")
                .bodyValue(joarkStatus)
                .retrieve()
                .toBodilessEntity()
                .block() ?: throw RuntimeException("Unable to send Joark status for klage in klage-dittnav-api.")
    }
}