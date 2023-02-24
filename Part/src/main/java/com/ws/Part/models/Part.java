package com.ws.Part.models;

import jakarta.persistence.*;

@Entity
@Table
public class Part {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String specification;

    public Part() {
    }

    public Part(Long id, String name, String specification) {
        id = id;
        this.name = name;
        this.specification = specification;
    }

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }
}
