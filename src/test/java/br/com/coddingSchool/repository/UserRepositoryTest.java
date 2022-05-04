package br.com.coddingSchool.repository;

import br.com.coddingSchool.DatabaseTestEnvironment;
import br.com.coddingSchool.model.access.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
    void findByEmail__should_be_devolve_nothing_if_receives_invalid_email() {
        Optional<User> user = userRepository.findByEmail("invalidEmail@gmail.com");
        assertFalse(user.isPresent());
    }

    @Test
    void findByEmail__Should_be_devolve_correct_user() {
        Optional<User> user = userRepository.findByEmail("newuser@gmail.com");
        assertTrue(user.isPresent());
        assertEquals("User name", user.get().getName());
    }
}