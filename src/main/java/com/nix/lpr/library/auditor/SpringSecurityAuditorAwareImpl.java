package com.nix.lpr.library.auditor;

import com.nix.lpr.library.entity.User;
import com.nix.lpr.library.repository.UserRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SpringSecurityAuditorAwareImpl implements AuditorAware<String> {
    private final UserRepository userRepository;

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }

        // I store userId as username in the Principal object because of the need to perform Spring Security setup correctly
        // Don't hit me ;)
        Integer userId = Integer.parseInt(((UserDetails) authentication.getPrincipal()).getUsername());
        return userRepository
                .findById(userId)
                .map(User::getLogin);
    }
}
