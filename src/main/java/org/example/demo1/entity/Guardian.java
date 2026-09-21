package org.example.demo1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "guardians")
public class Guardian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 60)
    @Size(min = 3, max = 60)
    private String displayName;
    @Column(nullable = false, unique = true)
    @Email
    private String email;
    @Column(nullable = false)
    @Email
    private String notificationEmail;
    @Column(nullable = false, updatable = false)
    private Instant createdAt;
}
