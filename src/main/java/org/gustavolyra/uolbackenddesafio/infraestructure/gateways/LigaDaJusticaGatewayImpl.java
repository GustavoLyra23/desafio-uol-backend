package org.gustavolyra.uolbackenddesafio.infraestructure.gateways;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.gustavolyra.uolbackenddesafio.domain.gateways.GroupHeroGateway;
import org.gustavolyra.uolbackenddesafio.infraestructure.models.xml.LigaDaJustica;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.StringReader;
import java.util.List;

@Component
public class LigaDaJusticaGatewayImpl implements GroupHeroGateway {
    private final RestTemplate restTemplate;
    private final JAXBContext jaxbContext;

    public LigaDaJusticaGatewayImpl() {
        try {
            this.restTemplate = new RestTemplate();
            this.jaxbContext = JAXBContext.newInstance(LigaDaJustica.class);
        } catch (JAXBException e) {
            throw new RuntimeException("Error initializing JAXB", e);
        }
    }

    @Override
    public List<String> fetch(String url) {
        try {
            String xmlResponse = restTemplate.getForObject(url, String.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            LigaDaJustica ligaDaJustica = (LigaDaJustica) unmarshaller.unmarshal(new StringReader(xmlResponse));

            return ligaDaJustica.getCodinomes().getCodinome();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching Liga da Justiça: " + e.getMessage(), e);
        }
    }
}