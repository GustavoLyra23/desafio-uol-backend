package org.gustavolyra.uolbackenddesafio.infraestructure.models.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Codinomes {
    @XmlElement(name = "codinome")
    private List<String> codinome;
}