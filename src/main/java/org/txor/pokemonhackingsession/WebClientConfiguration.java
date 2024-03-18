package org.txor.pokemonhackingsession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;


@Configuration
public class WebClientConfiguration {

    @Bean
    public WebClient getWebClient(HttpClient httpClient) {
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .exchangeStrategies(ExchangeStrategies
                        .builder()
                        .codecs(codecs -> codecs
                                .defaultCodecs()
                                .maxInMemorySize(50000 * 1024))
                        .build())
                .build();
    }

    @Bean
    public HttpClient getHttpClient() {
        HttpClient httpClient = HttpClient.create();
        httpClient.headers(headers -> {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("User-Agent", "lolo-the-wolf");
        });
        return httpClient;
    }


}
