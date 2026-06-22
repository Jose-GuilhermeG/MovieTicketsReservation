package io.github.CineTickets.models;

import io.github.CineTickets.core.models.BaseModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "seats")
@Getter
@Setter
@ToString
public class Seats extends BaseModel {

    @Column(name = "row_label" , length = 10 , nullable = false)
    private String rowLabel;

    @Column(name = "seat_number" , nullable = false)
    private Integer seatNumber;

}
