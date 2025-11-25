package com.LegalCore.ms_auth.shared.helpers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medical.onepay.config.onePay.OnePayProperties;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OnePayHelper {

    private final OnePayProperties properties;

    @Qualifier("onePayWebClient")
    private final WebClient webClient;

    private final ObjectMapper mapper = new ObjectMapper();

    // =============================
    // VERSIÓN SIN IDEMPOTENCY
    // =============================
    public <T> T callOnePay(
            String method,
            String endpoint,
            Object body,
            Class<T> responseType
    ) {
        return callOnePay(method, endpoint, body, responseType, null);
    }

    // =============================
    // VERSIÓN CON IDEMPOTENCY
    // =============================
    public <T> T callOnePay(
            String method,
            String endpoint,
            Object body,
            Class<T> responseType,
            String idempotencyKey
    ) {

        String token = properties.getKeyPrivate();

        try {
            WebClient.RequestBodySpec request = webClient
                    .method(HttpMethod.valueOf(method))
                    .uri(endpoint)
                    .header("Authorization", "Bearer " + token);

            if (idempotencyKey != null) {
                request.header("x-idempotency", idempotencyKey);
            }

            if (body != null) {
                request.bodyValue(body);
            }

            String rawResponse = request
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            return mapper.readValue(rawResponse, responseType);

        } catch (WebClientResponseException e) {
            log.error("Error OnePay ({}): {}", e.getStatusCode(), e.getResponseBodyAsString());
            throw new RuntimeException(e.getResponseBodyAsString(), e);

        } catch (Exception e) {
            log.error("Error procesando JSON: {}", e.getMessage());
            throw new RuntimeException("Error procesando JSON", e);
        }
    }

    public String toJson(Object obj) {
    try {
        return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
        return null;
    }
}

}
