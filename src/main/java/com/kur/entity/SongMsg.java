package com.kur.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
@AllArgsConstructor
@EqualsAndHashCode
public class SongMsg implements Serializable {
    private Integer code;
    private String msg;
    private SongData data;
}
