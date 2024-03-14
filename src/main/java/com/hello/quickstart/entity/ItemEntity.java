package com.hello.quickstart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ITEM")
public class ItemEntity {

    @Id
    @GeneratedValue
    private String id;

    private String name;
}
