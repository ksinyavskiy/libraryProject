package com.nix.lpr.library.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    @Column(name = "NAME", length = 15, unique = true, nullable = false)
    private String name;
    @Column(name = "DESCRIPTION", length = 100, nullable = false)
    private String description;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer id) {
        this.roleId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        if (this == object) {
            return true;
        }

        Role role = (Role) object;
        return Objects.equals(roleId, role.getRoleId()) &&
                Objects.equals(name, role.getName()) &&
                Objects.equals(description, role.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, name, description);
    }

    @Override
    public String toString() {
        return String.format("Role: name - %s", name);
    }
}
