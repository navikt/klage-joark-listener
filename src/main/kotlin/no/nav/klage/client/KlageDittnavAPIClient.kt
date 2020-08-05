package no.nav.klage.client

import no.nav.klage.domain.JournalpostStatus
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

    fun sendJournalpostStatusToKlage(journalpostId: String, journalpostStatus: JournalpostStatus) {
        logger.debug("Sending Journalpost status to klage-dittnav-api. JournalpostId: {}", journalpostId)
        klageDittnavAPIWebClient.post()
                .uri("/journalpoststatus/$journalpostId")
                .header(HttpHeaders.AUTHORIZATION, "Bearer ${azureADClient.oidcToken()}")
                .bodyValue(journalpostId)
                .retrieve()
                .toBodilessEntity()
                .block() ?: throw RuntimeException("Unable to send Journalpost status for klage in klage-dittnav-api.")
    }
}