package com.kur.entity.qq;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class SingerBean implements Serializable {
    /**
     * id : 4904
     * mid : 00081ZN91FD8QW
     * name : 吕方
     * title : 吕方
     */

    private Integer id;
    private String mid;
    private String name;
    private String title;
}
