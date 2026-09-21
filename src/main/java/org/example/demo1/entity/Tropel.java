package org.example.demo1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "tropels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tropel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true, length = 40)
    private String name;


}
