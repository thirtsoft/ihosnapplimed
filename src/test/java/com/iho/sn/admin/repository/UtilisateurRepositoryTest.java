package com.iho.sn.admin.repository;

import com.iho.sn.admin.entities.Utilisateur;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class UtilisateurRepositoryTest {

    // Arrange / Given
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    // Act / when


    // Assert / Then
    @Test
    void findByEmail_returnsEmpty_whenUserNotFound() {
//        Utilisateur utilisateur = Utilisateur.builder()
//                .email().build()

        assertThat(utilisateurRepository.findByEmail("email")).isEmpty();
    }

    @Test
    void findByEmail_returnsUser() {
        Utilisateur utilisateur = Utilisateur.builder()
                .email("email@gmail.com")
                .createdByUser("root")
                .creationDate(now())
                .build();
        utilisateurRepository.save(utilisateur);

        Optional<Utilisateur> result = utilisateurRepository.findByEmail(utilisateur.getEmail());

        assertThat(result).isNotEmpty();
        assertThat(result.get())
                .extracting(Utilisateur::getEmail)
                .isEqualTo(utilisateur.getEmail());
    }

}