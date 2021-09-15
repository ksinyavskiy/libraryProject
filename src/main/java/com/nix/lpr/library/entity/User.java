package com.nix.lpr.library.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "LAST_NAME", length = 30, nullable = false)
    private String lastName;
    @Column(name = "FIRST_NAME", length = 30, nullable = false)
    private String firstName;
    @Column(name = "LOGIN", length = 15, unique = true, nullable = false)
    private String login;
    @Column(name = "PASSWORD", length = 30, unique = true, nullable = false)
    private String password;
    @Column(name = "EMAIL", length = 40, unique = true, nullable = false)
    private String email;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROLE_ID")
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        if (this == object) {
            return true;
        }

        User user = (User) object;
        return Objects.equals(id, user.getId()) &&
                Objects.equals(lastName, user.getLastName()) &&
                Objects.equals(firstName, user.getFirstName()) &&
                Objects.equals(login, user.getLogin()) &&
                Objects.equals(password, user.getPassword()) &&
                Objects.equals(email, user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, login, password, email);
    }

    @Override
    public String toString() {
        return String.format("User: id - %d, login - %s", id, login);
    }
}
