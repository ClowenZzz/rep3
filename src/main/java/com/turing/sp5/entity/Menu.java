package com.turing.sp5.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Menu {
    private Integer id;
    @JsonProperty(value = "text")
    private  String name;

    private Integer pid;

   private List<Menu> children;
}
