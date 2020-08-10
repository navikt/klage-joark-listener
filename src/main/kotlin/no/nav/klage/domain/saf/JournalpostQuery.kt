package no.nav.klage.domain.saf

data class JournalpostQuery(
    val query: String,
    val variables: JournalpostQueryVariables
)

data class JournalpostQueryVariables(val journalpostId: String)
