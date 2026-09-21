package org.example.demo1.config;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.example.demo1.Repository.GuardianRepository;
import org.example.demo1.Service.GuardianService;
import org.example.demo1.entity.Guardian;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements ApplicationRunner {

    private final GuardianRepository repository;
    private final GuardianService service;

    @Value("${ADMIN_NAME}")
    private String adminName;

    @Value("${ADMIN_EMAIL}")
    private String adminEmail;

    @Value("${ADMIN_NOTIFICATION_EMAIL}")
    private String adminNotificationEmail;

    @Override
    public void run(ApplicationArguments args) {
        if (repository.existsByEmail(adminEmail)) {
            log.info("El guardián admin ya existe, no se crea de nuevo");
            return;
        }
        service.create(Guardian.builder()
                .displayName(adminName)
                .email(adminEmail)
                .notificationEmail(adminNotificationEmail)
                .build());
        log.info("Guardián admin creado: {}", adminEmail);
    }
}
