package com.kur.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Results implements Serializable {
    private Integer code;
    private String msg;
    private DataBean data;
}
