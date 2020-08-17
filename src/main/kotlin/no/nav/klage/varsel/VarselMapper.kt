package no.nav.klage.varsel

import no.nav.melding.virksomhet.varsel.v1.varsel.*

private const val varseltype = "KlageMottattVarsel"
private const val fornavnKey = "FORNAVN"
private const val datoKey = "DATO"
private const val urlKey = "URL"
private const val urlValue = "https://klage-dittnav.nav.no"

fun varselFromJournalfoeringHendelse(
    aktoerId: String,
    fornavn: String,
    journalfoeringsdato: String
): Varsel = Varsel().apply {
    mottaker = AktoerId().apply {
        setAktoerId(aktoerId)
    }
    varslingstype = Varslingstyper().apply {
        value = varseltype
    }
    parameterListe.setVarselParametre(fornavn, journalfoeringsdato)
}

private fun MutableList<Parameter>.setVarselParametre(
    fornavn: String,
    journalfoeringsdato: String
) {
    this.add(Parameter().apply {
        key = fornavnKey
        value = fornavn
    })
    this.add(Parameter().apply {
        key = datoKey
        value = journalfoeringsdato
    })
    this.add(Parameter().apply {
        key = urlKey
        value = urlValue
    })
}
