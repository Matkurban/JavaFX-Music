package com.kur.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lists implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String listname;

    private String listid;

    private String type;

}
