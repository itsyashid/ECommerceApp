package com.example.ecommerceapp.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class BaseModel {
    private long id;
    private Date createdAt;
    private Date lastupdatedAt;
    private State state;
}
