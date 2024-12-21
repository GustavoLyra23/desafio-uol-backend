package org.gustavolyra.uolbackenddesafio.infraestructure.models.xml;

import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;

import java.util.List;

@Data
public class Codinomes {
    @XmlElement(name = "codinome")
    private List<String> codinome;
}