package dev.indra.presentation.dto.user;

public class UserRequestTO {

    private String username;

    private String password;

    public UserRequestTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("UserRequest [username=%s, password=%s]", username, password);
    }

}
