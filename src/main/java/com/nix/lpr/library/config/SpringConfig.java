package com.nix.lpr.library.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.nix.lpr.library"})
@EnableAspectJAutoProxy
public class SpringConfig {
}
