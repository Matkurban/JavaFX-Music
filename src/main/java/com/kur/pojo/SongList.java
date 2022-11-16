package com.kur.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SongList implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String songlistname;

    private String songlistid;

    private String type;
}
