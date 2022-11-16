package com.kur.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class SongData implements Serializable {
    private String name;
    private String album;
    private String artist;
    private String url;
    private String pic;
    private String lrc;
}
