package com.yunussen.kafkademo.model.request;

import lombok.Data;

@Data
public class Person {
    private String name;
    private String surname;
    private String description;
    private Integer age;
}
