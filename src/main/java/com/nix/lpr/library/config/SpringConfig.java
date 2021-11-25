package com.nix.lpr.library.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@ComponentScan(basePackages = {"com.nix.lpr.library"})
@EnableAspectJAutoProxy
@EnableJpaAuditing
public class SpringConfig {
}
