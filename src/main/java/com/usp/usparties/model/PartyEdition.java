package com.usp.usparties.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class PartyEdition implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String local;
    private String date;

    @ManyToOne
    private Lot actualLot;

    @ManyToMany
    private List<Lot> lots;

    @ManyToOne
    private Party party;

}
