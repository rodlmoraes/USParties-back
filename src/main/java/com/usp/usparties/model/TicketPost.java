package com.usp.usparties.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TicketPost implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private Integer amount;
    private Integer price;

    @ManyToOne
    @JsonBackReference(value = "salesman")
    private Salesman salesman;

    @ManyToOne
    private PartyEdition partyEdition;
}
