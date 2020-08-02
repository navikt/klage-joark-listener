package no.nav.klage.config

import com.ibm.mq.constants.CMQC.MQENC_NATIVE
import com.ibm.mq.jms.MQQueueConnectionFactory
import com.ibm.msg.client.jms.JmsConstants.JMS_IBM_CHARACTER_SET
import com.ibm.msg.client.jms.JmsConstants.JMS_IBM_ENCODING
import com.ibm.msg.client.wmq.common.CommonConstants.WMQ_CM_CLIENT
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter
import org.springframework.jms.core.JmsTemplate
import org.springframework.jms.support.destination.DynamicDestinationResolver
import java.net.URI
import javax.jms.ConnectionFactory

@Configuration
class VarselConfiguration {
    private val UTF_8_WITH_PUA = 1208

    @Value("\${VARSEL_URI}")
    private lateinit var uri: URI

    @Value("\${VARSEL_CHANNEL_NAME}")
    private lateinit var channelName: String

    @Value("\${VARSEL_QUEUE_NAME}")
    private lateinit var queueName: String

    @Value("\${VARSEL_USERNAME}")
    private lateinit var username: String

    @Bean
    fun varselJmsTemplate(jmsConnectionFactory: ConnectionFactory): JmsTemplate {
        val jmsTemplate = JmsTemplate(jmsConnectionFactory)
        jmsTemplate.defaultDestinationName = queueName
        jmsTemplate.destinationResolver = DynamicDestinationResolver()
        return jmsTemplate
    }

    @Bean
    fun jmsConnectionFactory(): ConnectionFactory {
        val cf = UserCredentialsConnectionFactoryAdapter()
        cf.setUsername(username)
        cf.setTargetConnectionFactory(targetConnectionFactory())
        return cf
    }

    private fun targetConnectionFactory(): ConnectionFactory {
        val cf = MQQueueConnectionFactory()
        cf.hostName = uri.host
        cf.port = uri.port
        cf.queueManager = uri.path
        cf.channel = channelName
        cf.transportType = WMQ_CM_CLIENT
        cf.ccsid = UTF_8_WITH_PUA
        cf.setIntProperty(JMS_IBM_ENCODING, MQENC_NATIVE)
        cf.setIntProperty(JMS_IBM_CHARACTER_SET, UTF_8_WITH_PUA)
        return cf
    }

}
