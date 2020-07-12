package dev.indra.presentation.assembler;

import java.util.List;
import java.util.stream.Collectors;

import dev.indra.domain.model.user.User;
import dev.indra.presentation.dto.user.UserRequestTO;
import dev.indra.presentation.dto.user.UserResponseTO;

public final class UserAssembler {
    
    private UserAssembler() {
    }
    
    public static User from(UserRequestTO requestTO) {
        return new User(requestTO.getUsername(), requestTO.getPassword(), requestTO.getDateBirth());
    }
    
    public static UserResponseTO from(User user) {
        return new UserResponseTO(user.getId(), user.getUsername(), user.getDateBirth());
    }
    
    public static List<UserResponseTO> from(List<User> users) {
        return users.stream().map(UserAssembler::from).collect(Collectors.toList());
    }

}
