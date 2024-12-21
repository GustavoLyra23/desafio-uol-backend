package org.gustavolyra.uolbackenddesafio.infraestructure.models.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@XmlRootElement(name = "liga_da_justica")
@XmlAccessorType(XmlAccessType.FIELD)
public class LigaDaJustica {
    @XmlElement(name = "codinomes")
    private Codinomes codinomes;
}