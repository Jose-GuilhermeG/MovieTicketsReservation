package io.github.CineTickets.models;


import io.github.CineTickets.core.ColumnSize;
import io.github.CineTickets.core.models.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@ToString
public class Rooms extends BaseModel {

    @Column(nullable = false , length = ColumnSize.MEDIUMCHARSIZE,unique = true)
    private String name;

    @Column(nullable = false)
    private Integer capacity;

}
