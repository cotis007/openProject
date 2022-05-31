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
@Table(name = "category_of_research")
public class CategoryOfResearch implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinColumn(name = "category_of_research_id")
    private List<SubCategoryOfResearch> subCategoryOfResearch;

    @OneToMany
    @JoinColumn(name = "category_of_research_id")
    private List<EquipmentList> equipmentLists;
}

