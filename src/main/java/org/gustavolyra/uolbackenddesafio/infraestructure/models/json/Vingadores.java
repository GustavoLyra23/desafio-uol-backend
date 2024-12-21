package org.gustavolyra.uolbackenddesafio.infraestructure.models.json;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
public class Vingadores {
    private List<Vingador> vingadores;
}
