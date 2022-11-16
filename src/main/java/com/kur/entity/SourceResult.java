package com.kur.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SourceResult implements Serializable {
    private Integer code;
    private String msg;
    private List<Song> data;
}
