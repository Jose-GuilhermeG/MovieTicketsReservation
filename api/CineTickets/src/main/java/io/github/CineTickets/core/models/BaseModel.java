package io.github.CineTickets.core.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class BaseModel extends AuditModel {
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
}
