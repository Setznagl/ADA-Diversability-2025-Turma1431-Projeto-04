package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Configuration
@Slf4j
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getInterceptors().add(logInterceptor());

        restTemplate.setErrorHandler(customErrorHandler());

        return restTemplate;
    }

    private ClientHttpRequestInterceptor logInterceptor() {
        return (request, body, execution) -> {
            long start = System.currentTimeMillis();

            ClientHttpResponse response = execution.execute(request, body);

            long duration = System.currentTimeMillis() - start;

            log.info("[PokeAPI] {} {} -> {} ({} ms)",
                    request.getMethod(),
                    request.getURI(),
                    response.getStatusCode(),
                    duration);

            return response;
        };
    }

    private ResponseErrorHandler customErrorHandler() {
        return new ResponseErrorHandler() {

            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return response.getStatusCode().isError();
            }

            @Override
            @SuppressWarnings("removal")
            public void handleError(ClientHttpResponse response) throws IOException {
                log.error("[PokeAPI] Erro: {} - {}", response.getStatusCode(), response.getStatusText());
            }
        };
    }
}
