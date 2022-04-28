package br.com.coddingSchool.repository;

import br.com.coddingSchool.model.access.User;
import br.com.coddingSchool.util.setup.GeneralSetup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    private void setup() {
        GeneralSetup generalSetup = new GeneralSetup(userRepository);
        generalSetup.setupUser();
    }

    @Test // TODO: Renomear
    void findByEmail() {
        assertDoesNotThrow(() -> userRepository.findByEmail("newuser@gmail.com")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));

        assertThrows(ResponseStatusException.class, () -> userRepository.findByEmail("invalid@gmail.com")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));

        User user = userRepository.findByEmail("newuser@gmail.com")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        assertEquals("User name", user.getName());
    }
}