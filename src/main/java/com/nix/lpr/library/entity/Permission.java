package com.nix.lpr.library.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "permission")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer permissionId;
    @Column(name = "NAME", length = 20, unique = true, nullable = false)
    private String name;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return Objects.equals(permissionId, permission.getPermissionId()) && Objects.equals(name, permission.getName());
    }

    @Override
    public String toString() {
        return String.format("Permission: name - %s", name);
    }
}
