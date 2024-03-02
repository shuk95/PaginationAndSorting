package com.codes.shuk.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditAwareImpl implements AuditorAware<String> { //this class will be automatically called and return the username
    @Override
    public Optional<String> getCurrentAuditor() {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        return Optional.ofNullable(user);
    }
}
