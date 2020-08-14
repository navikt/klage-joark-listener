package no.nav.klage.varsel

import no.nav.joarkjournalfoeringhendelser.JournalfoeringHendelseRecord
import no.nav.melding.virksomhet.varsel.v1.varsel.Varsel

fun varselFromJournalfoeringHendelse(hendelse: JournalfoeringHendelseRecord): Varsel {
    return Varsel()
}
