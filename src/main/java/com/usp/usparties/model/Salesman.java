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
public class Salesman implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String tel;
    private String university;
    private String campus;
    private String email;
    private String password;

    @OneToMany(mappedBy = "salesman")
    @JsonManagedReference(value = "salesman")
    private List<TicketPost> ticketPosts;
}
