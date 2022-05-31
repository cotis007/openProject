package com.impl.vk.repostiroty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "equipment")
public class Equipment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String serialNumber;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Address address;

    @OneToMany
    @JoinColumn
    private List<Person> person;

    @Column
    private String description;
}
