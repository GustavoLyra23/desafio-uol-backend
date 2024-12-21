package org.gustavolyra.uolbackenddesafio.infraestructure.gateways;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.gustavolyra.uolbackenddesafio.domain.gateways.GroupHeroGateway;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class VingadoresGatewayImpl implements GroupHeroGateway {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public VingadoresGatewayImpl(ObjectMapper objectMapper) {
        this.restTemplate = new RestTemplate();
        this.objectMapper = objectMapper;
    }

    @Override
    public List<String> fetch(String url) {
        try {
            String jsonResponse = restTemplate.getForObject(url, String.class);
            JsonNode rootNode = objectMapper.readTree(jsonResponse);
            List<String> codinomes = new ArrayList<>();
            JsonNode vingadoresNode = rootNode.get("vingadores");

            if (vingadoresNode.isArray()) {
                vingadoresNode.forEach(vingador -> {
                    String codinome = vingador.get("codinome").asText();
                    codinomes.add(codinome);
                });
            }

            return codinomes;
        } catch (Exception e) {
            throw new RuntimeException("Error fetching vingadores: " + e.getMessage(), e);
        }
    }
}