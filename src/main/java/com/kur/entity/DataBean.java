package com.kur.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataBean implements Serializable {
    private String[] songId;
    private String[] songName;
    private String[] albumName;
    private String[] artistName;
    private String[] type;
}
