package org.gustavolyra.uolbackenddesafio.application.service;

import org.gustavolyra.uolbackenddesafio.domain.gateways.db.JogadorRepository;
import org.gustavolyra.uolbackenddesafio.domain.models.Jogador;
import org.gustavolyra.uolbackenddesafio.domain.models.dto.JogadorDTO;
import org.gustavolyra.uolbackenddesafio.domain.models.dto.JogadorReponseDTO;
import org.gustavolyra.uolbackenddesafio.domain.enums.Grupo;
import org.gustavolyra.uolbackenddesafio.utils.MapperUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JogadorServiceImplTest {

    @Mock
    private JogadorRepository jogadorRepository;

    @Mock
    private GroupHeroService groupHeroService;

    private JogadorServiceImpl jogadorService;

    @BeforeEach
    void setUp() {
        jogadorService = new JogadorServiceImpl(jogadorRepository, groupHeroService);
    }

    @Test
    void create_ShouldCreateJogadorWithRandomCodinome() {
        // Arrange
        JogadorDTO dto = new JogadorDTO(
                "John Doe",
                "john@example.com",
                "123456789",
                Grupo.VINGADORES
        );

        List<String> availableCodinomes = Arrays.asList("Iron Man", "Thor", "Hulk");
        List<String> usedCodinomes = List.of("Captain America");

        Jogador mockJogador = new Jogador();
        mockJogador.setId(UUID.randomUUID());
        mockJogador.setNome(dto.nome());
        mockJogador.setEmail(dto.email());
        mockJogador.setTelefone(dto.telefone());
        mockJogador.setGrupo(dto.grupo());
        mockJogador.setCodinome("Iron Man");

        Jogador mappedJogador = new Jogador();
        mappedJogador.setNome(dto.nome());
        mappedJogador.setEmail(dto.email());
        mappedJogador.setTelefone(dto.telefone());
        mappedJogador.setGrupo(dto.grupo());

        try (MockedStatic<MapperUtil> mockedMapper = mockStatic(MapperUtil.class)) {
            mockedMapper.when(() -> MapperUtil.map(eq(dto), eq(Jogador.class)))
                    .thenReturn(mappedJogador);

            when(groupHeroService.fetchGroupData(dto.grupo()))
                    .thenReturn(Arrays.asList("Iron Man", "Thor", "Hulk", "Captain America"));
            when(jogadorRepository.findUsedCodinomes(dto.grupo()))
                    .thenReturn(usedCodinomes);
            when(jogadorRepository.create(any(Jogador.class)))
                    .thenReturn(mockJogador);

            // Act
            JogadorReponseDTO result = jogadorService.create(dto);

            // Assert
            assertThat(result).isNotNull();
            assertThat(result.getNome()).isEqualTo(dto.nome());
            assertThat(result.getEmail()).isEqualTo(dto.email());
            assertThat(result.getTelefone()).isEqualTo(dto.telefone());
            assertThat(result.getGrupo()).isEqualTo(dto.grupo().getNome());
            assertThat(result.getCodinome()).isIn(availableCodinomes);

            verify(groupHeroService).fetchGroupData(dto.grupo());
            verify(jogadorRepository).findUsedCodinomes(dto.grupo());
            verify(jogadorRepository).create(any(Jogador.class));
        }
    }

    @Test
    void findAll_ShouldReturnListOfJogadores() {
        // Arrange
        int page = 0;
        int size = 10;
        List<Jogador> jogadores = Arrays.asList(
                createJogador("John Doe", Grupo.VINGADORES, "Iron Man"),
                createJogador("Jane Doe", Grupo.LIGA_DA_JUSTICA, "Batman")
        );

        when(jogadorRepository.findAll(page, size)).thenReturn(jogadores);

        try (MockedStatic<MapperUtil> mockedMapper = mockStatic(MapperUtil.class)) {
            mockedMapper.when(() -> MapperUtil.map(any(Jogador.class), eq(JogadorReponseDTO.class)))
                    .thenAnswer(invocation -> {
                        Jogador j = invocation.getArgument(0);
                        return JogadorReponseDTO.builder()
                                .id(j.getId().toString())
                                .nome(j.getNome())
                                .email(j.getEmail())
                                .telefone(j.getTelefone())
                                .grupo(j.getGrupo().getNome())
                                .codinome(j.getCodinome())
                                .build();
                    });

            // Act
            List<JogadorReponseDTO> result = jogadorService.findAll(page, size);

            // Assert
            assertThat(result).hasSize(2);
            assertThat(result.get(0).getNome()).isEqualTo("John Doe");
            assertThat(result.get(0).getGrupo()).isEqualTo(Grupo.VINGADORES.getNome());
            assertThat(result.get(0).getCodinome()).isEqualTo("Iron Man");
            assertThat(result.get(1).getNome()).isEqualTo("Jane Doe");
            assertThat(result.get(1).getGrupo()).isEqualTo(Grupo.LIGA_DA_JUSTICA.getNome());
            assertThat(result.get(1).getCodinome()).isEqualTo("Batman");

            verify(jogadorRepository).findAll(page, size);
        }
    }

    @Test
    void findAvailableCodinomes_ShouldReturnAvailableCodinomes() {
        // Arrange
        JogadorDTO dto = new JogadorDTO(
                "John Doe",
                "john@example.com",
                "123456789",
                Grupo.VINGADORES
        );

        List<String> allCodinomes = Arrays.asList("Iron Man", "Thor", "Hulk", "Captain America");
        List<String> usedCodinomes = Arrays.asList("Captain America");

        when(groupHeroService.fetchGroupData(dto.grupo())).thenReturn(allCodinomes);
        when(jogadorRepository.findUsedCodinomes(dto.grupo())).thenReturn(usedCodinomes);

        // Act
        List<String> result = jogadorService.findAvailableCodinomes(dto);

        // Assert
        assertThat(result).hasSize(3);
        assertThat(result).contains("Iron Man", "Thor", "Hulk");
        assertThat(result).doesNotContain("Captain America");

        verify(groupHeroService).fetchGroupData(dto.grupo());
        verify(jogadorRepository).findUsedCodinomes(dto.grupo());
    }

    @Test
    void setRandomCodinome_ShouldReturnRandomCodinome() {
        // Arrange
        List<String> availableCodinomes = Arrays.asList("Iron Man", "Thor", "Hulk");

        // Act
        String result = jogadorService.setRandomCodinome(availableCodinomes);

        // Assert
        assertThat(result).isIn(availableCodinomes);
    }

    private Jogador createJogador(String nome, Grupo grupo, String codinome) {
        Jogador jogador = new Jogador();
        jogador.setId(UUID.randomUUID());
        jogador.setNome(nome);
        jogador.setEmail(nome.toLowerCase().replace(" ", ".") + "@example.com");
        jogador.setTelefone("123456789");
        jogador.setGrupo(grupo);
        jogador.setCodinome(codinome);
        return jogador;
    }
}