package com.nix.lpr.library.entity;

import java.util.Objects;
import java.util.Set;

public class Permission {
    private Integer id;
    private String name;
    private Set<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        if (this == object) {
            return true;
        }

        Permission permission = (Permission) object;
        return Objects.equals(id, permission.getId()) && Objects.equals(name, permission.getName());
    }

    @Override
    public String toString() {
        return String.format("Permission: name - %s", name);
    }
}
