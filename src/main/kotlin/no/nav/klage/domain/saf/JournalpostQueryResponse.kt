package no.nav.klage.domain.saf

data class JournalpostQueryResponse(val data: JournalpostWrapper? = null)

data class JournalpostWrapper(val journalpost: Journalpost? = null)

data class Journalpost(
    val journalpostId: String? = null,
    val tittel: String? = null,
    val journalposttype: String? = null,
    val journalstatus: String? = null,
    val tema: String? = null,
    val temanavn: String? = null,
    val behandlingstema: String? = null,
    val behandlingstemanavn: String? = null,
    val avsenderMottakerNavn: String? = null,
    val avsenderMottakerLand: String? = null,
    val journalforendeEnhet: String? = null,
    val journalfortAvNavn: String? = null,
    val opprettetAvNavn: String? = null,
    val kanal: String? = null,
    val kanalnavn: String? = null,
    val datoOpprettet: String? = null,
    val tilleggsopplysninger: List<Tilleggsopplysninger> = emptyList(),
    val sak: Sak? = null,
    val bruker: Bruker? = null,
    val dokumenter: List<Dokument> = emptyList(),
    val relevanteDatoer: List<RelevantDato> = emptyList()
) {
    data class Tilleggsopplysninger(val nokkel: String?, val verdi: String?)

    data class Sak(
        val arkivsaksnummer: String? = null,
        val arkivsaksystem: String? = null,
        val datoOpprettet: String? = null,
        val fagsakId: String? = null,
        val fagsaksystem: String? = null
    )

    data class Bruker(
        val id: String? = null,
        val type: String? = null
    )

    data class Dokument(
        val dokumentInfoId: String? = null,
        val tittel: String? = null,
        val brevkode: String? = null,
        val dokumentstatus: String? = null,
        val logiskeVedlegg: List<LogiskVedlegg> = emptyList(),
        val dokumentvarianter: List<Dokumentvariant> = emptyList()

    ) {
        data class LogiskVedlegg(val tittel: String? = null)

        data class Dokumentvariant(
            val variantformat: String? = null,
            val saksbehandlerHarTilgang: Boolean
        )
    }

    data class RelevantDato(val dato: String? = null, val datotype: String? = null)
}