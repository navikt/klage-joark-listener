package no.nav.klage.config

import no.nav.slackposter.SlackClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SlackConfiguration {
    @Value("\${SLACK_URL}")
    lateinit var url: String

    @Value("\${SLACK_CHANNEL_ID_JOARK_LISTENER}")
    lateinit var channelId: String

    @Value("\${NAIS_CLUSTER_NAME}")
    lateinit var cluster: String

    @Bean
    fun slackClient(): SlackClient = SlackClient(url, channelId, "klage-joark-listener", cluster)
}
