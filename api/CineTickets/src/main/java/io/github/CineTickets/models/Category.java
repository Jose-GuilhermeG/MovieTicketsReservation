package io.github.CineTickets.models;

import io.github.CineTickets.core.ColumnSize;
import io.github.CineTickets.core.models.BaseModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
@Data
@ToString(exclude = "movies")
public class Category extends BaseModel {

    @Column(nullable = true , unique = true , length = ColumnSize.SHORTCHARSIZE)
    private String name;

    @Column
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Movie> movies = new HashSet<>();

}
