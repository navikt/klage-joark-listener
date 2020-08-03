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

@Configuration
class VarselConfiguration {
    private val utf8WithPua = 1208

    @Value("\${VARSEL_URI}")
    private lateinit var uri: URI

    @Value("\${VARSEL_CHANNEL_NAME}")
    private lateinit var channelName: String

    @Value("\${VARSEL_QUEUE_NAME}")
    private lateinit var queueName: String

    @Value("\${VARSEL_USERNAME}")
    private lateinit var username: String

    @Bean
    fun varselJmsTemplate() = JmsTemplate(jmsConnectionFactory()).apply {
        defaultDestinationName = queueName
        destinationResolver = DynamicDestinationResolver()
    }

    private fun jmsConnectionFactory() = UserCredentialsConnectionFactoryAdapter().apply {
        setUsername(username)
        setTargetConnectionFactory(targetConnectionFactory())
    }

    private fun targetConnectionFactory() = MQQueueConnectionFactory().apply {
        hostName = uri.host
        port = uri.port
        queueManager = uri.path
        channel = channelName
        transportType = WMQ_CM_CLIENT
        ccsid = utf8WithPua
        setIntProperty(JMS_IBM_ENCODING, MQENC_NATIVE)
        setIntProperty(JMS_IBM_CHARACTER_SET, utf8WithPua)
    }
}
