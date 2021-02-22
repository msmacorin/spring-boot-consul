package br.com.macor.customers.clients;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class SalesServiceClient {

    private final WebClient webClient;

    public SalesServiceClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://sales-service").build();
    }

    @PostConstruct
    public void accessSalesService() {
        int i = 0;
        while (i < 100) {
            log.info("Request {}", i);
            sendRequest().doOnNext(r -> log.info("Response: {}", r)).subscribe();
            i++;
        }
    }

    Mono<String> sendRequest() {
        return webClient.get().uri("/api/v1/sales").retrieve().bodyToMono(String.class);
    }
}
