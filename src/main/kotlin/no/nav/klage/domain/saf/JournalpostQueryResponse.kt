package no.nav.klage.domain.saf

data class JournalpostQueryResponse(val data: Journalpost)

data class Journalpost(
    val journalpostId: String?,
    val tittel: String?,
    val journalposttype: String?,
    val journalstatus: String?,
    val tema: String?,
    val temanavn: String?,
    val behandlingstema: String?,
    val behandlingstemanavn: String?,
    val avsenderMottakerNavn: String?,
    val avsenderMottakerLand: String?,
    val journalforendeEnhet: String?,
    val journalfortAvNavn: String?,
    val opprettetAvNavn: String?,
    val kanal: String?,
    val kanalnavn: String?,
    val datoOpprettet: String?,
    val tilleggsopplysninger: List<Tilleggsopplysninger> = emptyList(),
    val sak: Sak,
    val bruker: Bruker,
    val dokumenter: List<Dokument> = emptyList()
) {
    data class Tilleggsopplysninger(val nokkel: String?, val verdi: String?)

    data class Sak(
        val arkivsaksnummer: String?,
        val arkivsaksystem: String?,
        val datoOpprettet: String?,
        val fagsakId: String?,
        val fagsaksystem: String?
    )

    data class Bruker(
        val id: String?,
        val type: String?
    )

    data class Dokument(
        val dokumentInfoId: String?,
        val tittel: String?,
        val brevkode: String?,
        val dokumentstatus: String?,
        val logiskeVedlegg: List<LogiskVedlegg> = emptyList(),
        val dokumentvarianter: List<Dokumentvariant> = emptyList()

    ) {
        data class LogiskVedlegg(val tittel: String?)

        data class Dokumentvariant(
            val variantformat: String?,
            val saksbehandlerHarTilgang: Boolean
        )
    }
}