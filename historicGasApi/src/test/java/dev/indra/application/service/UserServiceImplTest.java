package dev.indra.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.indra.domain.model.user.User;
import dev.indra.domain.service.BaseService;

@ActiveProfiles("test")
@SpringBootTest
@DisplayName("Serviço de Usuário")
class UserServiceImplTest {

    @Autowired
    private BaseService<User> service;

    @Test
    @DisplayName("Testa a criação de usuários")
    void testSave() {
        User user = new User("Teste 1", "Teste 1");
        User userSaved = service.save(user);

        assertThat(userSaved).isNotNull();
        assertThat(userSaved.getId()).isNotNull();
        assertThat(userSaved.getUsername()).isEqualTo(user.getUsername());
        assertThat(userSaved.getPassword()).isEqualTo(user.getPassword());
    }

    @Test
    @DisplayName("Testa a atualização de usuários")
    void testUpdate() {
        User userSaved = service.save(new User("Teste A", "Teste A"));

        User userUpdated = service.update(userSaved.getId(), new User("Teste U", "Teste U"));

        assertThat(userUpdated).isNotNull();
        assertThat(userSaved.getId()).isEqualTo(userSaved.getId());
        assertThat(userUpdated.getUsername()).isNotEqualTo(userSaved.getUsername());
        assertThat(userUpdated.getPassword()).isNotEqualTo(userSaved.getPassword());
    }

    @Test
    @DisplayName("Testa a listagem de usuários")
    void testFindAll() {
        service.save(new User("Teste A", "Teste A"));
        service.save(new User("Teste B", "Teste B"));
        service.save(new User("Teste C", "Teste C"));
        service.save(new User("Teste D", "Teste D"));

        List<User> users = service.findAll();

        assertThat(users).isNotNull();
        assertThat(users.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("Testa a busca de um usuário")
    void testFindById() {
        Long id = service.save(new User("Teste A", "Teste A")).getId();
        service.save(new User("Teste B", "Teste B"));
        service.save(new User("Teste C", "Teste C"));
        service.save(new User("Teste D", "Teste D"));

        User user = service.findBy(id);

        assertThat(user).isNotNull();
        assertThat(user.getId()).isEqualTo(id);
    }

    @Test
    @DisplayName("Testa a exclusão de um usuário")
    @ExceptionHandler(RuntimeException.class)
    void testDelete() {
        Long id = service.save(new User("Teste A", "Teste A")).getId();
        service.delete(id);
        
        RuntimeException exception =
                assertThrows(RuntimeException.class,
                   () -> service.findBy(id));
        
        
        String expectedMessage = "Usuário inexistente";
        String actualMessage = exception.getMessage();
     
        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

}
