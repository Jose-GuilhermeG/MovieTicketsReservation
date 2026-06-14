package io.github.CineTickets.models;

import io.github.CineTickets.core.ColumnSize;
import io.github.CineTickets.core.models.BaseModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
@Data
@ToString
public class Movie extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = ColumnSize.LONGCHARSIZE)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String synopsis;

    @Column(name = "duration_minutes", nullable = false)
    private Integer durationMinutes;

    @Column(name = "age_rating", length = ColumnSize.SHORTCHARSIZE)
    private String ageRating;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @ManyToMany(mappedBy = "movies")
    private Set<Category> categories = new HashSet<Category>();

}