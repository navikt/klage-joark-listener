package no.nav.klage.util

import org.springframework.http.client.reactive.ReactorClientHttpConnector
import reactor.netty.http.client.HttpClient
import reactor.netty.tcp.ProxyProvider
import java.net.URL

fun getReactorClientHttpConnector(proxyUrl: String): ReactorClientHttpConnector {
    val uri = URL(proxyUrl)

    val httpClient: HttpClient = HttpClient.create()
            .tcpConfiguration { tcpClient ->
                tcpClient.proxy { proxy ->
                    proxy.type(ProxyProvider.Proxy.HTTP).host(uri.host).port(uri.port)
                }
            }

    return ReactorClientHttpConnector(httpClient)
}