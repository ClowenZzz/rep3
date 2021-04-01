package com.turing.sp5.entity;

import lombok.Data;

import java.util.List;

@Data
public class EasyUIDataGrid {
    private Integer total;

    private List<?> rows;
}
