package br.com.coddingSchool.util.builder;

import br.com.coddingSchool.model.access.User;

public class UserBuilder {

    private String name;
    private String email;
    private String password;

    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public User build() {
        return new User(name, email, password);
    }
}
