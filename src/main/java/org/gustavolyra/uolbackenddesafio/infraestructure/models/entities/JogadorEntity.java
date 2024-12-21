package org.gustavolyra.uolbackenddesafio.infraestructure.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.gustavolyra.uolbackenddesafio.domain.enums.Grupo;

import java.util.Objects;
import java.util.UUID;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jogador", indexes = {
        @Index(name = "idx_codinome", columnList = "codinome")
})
public class JogadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    @Column(unique = true, nullable = false)
    private String email;
    private String telefone;
    @Column(unique = true, nullable = false)
    private String codinome;
    @Enumerated(EnumType.STRING)
    private Grupo grupo;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        JogadorEntity that = (JogadorEntity) object;
        return Objects.equals(email, that.email) && Objects.equals(codinome, that.codinome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, codinome);
    }
}