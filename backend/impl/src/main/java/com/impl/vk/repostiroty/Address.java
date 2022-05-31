package com.impl.vk.repostiroty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String city;

    @Column
    private String address;

    @Column
    @OneToMany(mappedBy = "address")
    private List<Equipment> equipmentList;
}
