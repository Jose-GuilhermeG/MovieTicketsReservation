package io.github.CineTickets.core.models;

import jakarta.persistence.*;
import lombok.Data;

@MappedSuperclass
@Data
public class BaseModel extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Integer id;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
}
