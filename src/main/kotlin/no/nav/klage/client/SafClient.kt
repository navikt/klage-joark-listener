package no.nav.klage.client

import brave.Tracer
import no.nav.klage.domain.saf.JournalpostQuery
import no.nav.klage.domain.saf.JournalpostQueryVariables
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono

@Component
class SafClient(
    private val safWebClient: WebClient,
    private val stsClient: StsClient,
    private val tracer: Tracer
) {

    @Value("\${navCallId}")
    lateinit var navCallId: String

    fun getJournalpost(journalpostId: String): String {
        return safWebClient.post()
            .header(HttpHeaders.AUTHORIZATION, "Bearer ${stsClient.oidcToken()}")
            .header(navCallId, tracer.currentSpan().context().traceIdString())
            .bodyValue(journalpostQuery(journalpostId))
            .retrieve()
            .bodyToMono<String>()
            .block() ?: throw RuntimeException("Journalpost with id $journalpostId could not be fetched")
    }

    private fun journalpostQuery(journalpostId: String): JournalpostQuery {
        val query =
            JournalpostQuery::class.java.getResource("/graphql/journalpost.graphql").readText().replace("[\n\r]", "")
        return JournalpostQuery(
            query = query,
            variables = JournalpostQueryVariables(journalpostId = journalpostId)
        )
    }
}
