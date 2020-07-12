package dev.indra.presentation.assembler;

import dev.indra.domain.model.user.User;
import dev.indra.presentation.dto.user.UserRequestTO;
import dev.indra.presentation.dto.user.UserResponseTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@DisplayName("Assembler: Usuários")
class UserAssemblerTest {


    @Test
    @DisplayName("Deve converter um usuário em um DTO de resposta")
    void testEntityToResponseTO() {
         User entity = new  User("Teste 1", "Teste 1");
        entity.setId(1L);
         UserResponseTO responseTO =  UserAssembler.from(entity);

        assertThat(responseTO).isNotNull();
        assertThat(responseTO.getId()).isNotNull();
        assertThat(responseTO.getUsername()).isEqualTo(entity.getUsername());
    }
    
    @Test
    @DisplayName("Deve converter uma requisição em um usuário")
    void testRequestToEntity() {
        UserRequestTO requestTO = new  UserRequestTO();
        requestTO.setUsername("Teste 1");
        requestTO.setPassword("Teste 1");
        User entity =  UserAssembler.from(requestTO);

        assertThat(entity).isNotNull();
        assertThat(entity.getUsername()).isEqualTo(requestTO.getUsername());
        assertThat(entity.getPassword()).isEqualTo(requestTO.getPassword());
    }

}
