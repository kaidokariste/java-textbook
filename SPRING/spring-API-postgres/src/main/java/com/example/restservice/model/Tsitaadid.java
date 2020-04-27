package com.example.restservice.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;
import javax.persistence.*;


@Entity
@Table(name="tsitaadid")
public class Tsitaadid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    @ApiModelProperty(hidden = true)
    private Long id;

    private String quotation;
    private String author;

    public Tsitaadid(){
    }

    public Tsitaadid(String quotation, String author){
        this.quotation = quotation;
        this.author= author;
    }

    public Long getId() {
        return id;
    }

    public String getQuotation() {
        return quotation;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuotation(String quotation) {
        this.quotation = quotation;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
