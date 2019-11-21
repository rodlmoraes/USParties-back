package com.usp.usparties.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Party implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "party")
    @JsonIgnore
    private List<PartyEdition> partyEditions;

    @ManyToOne
    @JoinColumn(name = "academicCenter_id", nullable = false)
    @JsonBackReference(value = "academicCenter")
    private AcademicCenter academicCenter;
}
