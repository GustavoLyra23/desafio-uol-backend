package org.gustavolyra.uolbackenddesafio.infraestructure.models.xml;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "liga_da_justica")
public class LigaDaJustica {

    @XmlElement(name = "codinomes")
    private Codinomes codinomes;

}
