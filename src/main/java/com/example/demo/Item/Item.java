package com.example.demo.Item;
import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table

public class Item {
    @Id
    @SequenceGenerator(
        name = "item_sequence",
        sequenceName = "item_sequence",
        allocationSize = 1
    )

    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "item_sequence"
    )

    private Long Id;
    private String name;
    private String description;
    private LocalDate createDate;
    private Integer price;

    @Transient
    private Integer duration;


    public Item() {
    }

    public Item(Long id, String name, String description, LocalDate createDate, Integer price) {
        Id = id;
        this.name = name;
        this.description = description;
        this.createDate = createDate;
        this.price = price;
    }

    public Item(String name, String description, LocalDate createDate, Integer price) {
        this.name = name;
        this.description = description;
        this.createDate = createDate;
        this.price = price;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDuration() {
        return Period.between(this.createDate, LocalDate.now()).getYears();
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Item [Id=" + Id + ", createDate=" + createDate + ", description=" + description + ", name=" + name
                + ", price=" + price + "]";
    }

}
