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
@ToString
public class Category extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Integer id;

    @Column(nullable = true , unique = true , length = ColumnSize.SHORTCHARSIZE)
    private String name;

    @Column
    private String description;

    @ManyToMany
    @JoinTable(
            name = "movie_categories",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private Set<Movie> movies = new HashSet<Movie>();

}
