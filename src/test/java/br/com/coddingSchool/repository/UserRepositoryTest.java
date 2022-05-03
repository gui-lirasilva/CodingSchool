package br.com.coddingSchool.repository;

import br.com.coddingSchool.DatabaseTestEnvironment;
import br.com.coddingSchool.model.access.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest extends DatabaseTestEnvironment {

    @BeforeEach
    private void setup() {
        newUser();
    }

    @Test
    void findByEmail__shouldBeNotThrowAnyExceptionIfRecievesValidEmail() {
        assertDoesNotThrow(() -> userRepository.findByEmail("newuser@gmail.com")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Test
    void findByEmail__shouldBeThrowExceptionIfRecievesInvalidEmail() {
        assertThrows(ResponseStatusException.class, () -> userRepository.findByEmail("invalid@gmail.com")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @Test
    void findByEmail__ShouldBeDevolveCorrectUser() {
        User user = userRepository.findByEmail("newuser@gmail.com")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        assertEquals("User name", user.getName());
    }
}