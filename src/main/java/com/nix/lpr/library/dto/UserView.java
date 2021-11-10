package com.nix.lpr.library.dto;

import org.springframework.beans.factory.annotation.Value;

public interface UserView {

    @Value("#{target.lastName + ' ' + target.firstName}")
    String getFullName();

    String getEmail();
}
