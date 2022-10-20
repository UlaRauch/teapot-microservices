package com.example.blends.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "blends")
public class Blend {
    @Id
    private String id;

    private String name;

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", name=" + name +"]";
    }
}
