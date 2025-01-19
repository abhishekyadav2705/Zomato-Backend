package com.zomato.backend.entities;


import com.zomato.backend.entities.enums.FoodCategory;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "menu_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu; // The menu to which this item belongs

    @Column(nullable = false, length = 100)
    private String name; // Name of the menu item (e.g., Burger, Pasta)

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private Double price; // Price of the menu item

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Set<FoodCategory> foodCategory; // Category of the menu item (e.g., VEG, NON_VEG, VEGAN)

    @Column(nullable = false)
    private Boolean availability;

}

