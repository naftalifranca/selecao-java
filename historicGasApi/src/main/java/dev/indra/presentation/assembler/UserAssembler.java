package dev.indra.presentation.assembler;

import dev.indra.domain.model.user.User;
import dev.indra.presentation.dto.user.UserRequestTO;
import dev.indra.presentation.dto.user.UserResponseTO;

import java.util.List;
import java.util.stream.Collectors;

public final class UserAssembler {
    
    private UserAssembler() {
    }
    
    public static User from(UserRequestTO requestTO) {
        return new User(requestTO.getUsername(), requestTO.getPassword());
    }
    
    public static UserResponseTO from(User user) {
        return new UserResponseTO(user.getId(), user.getUsername());
    }
    
    public static List<UserResponseTO> from(List<User> users) {
        return users.stream().map(UserAssembler::from).collect(Collectors.toList());
    }

}
