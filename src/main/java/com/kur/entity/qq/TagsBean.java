package com.kur.entity.qq;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class TagsBean implements Serializable {
    /**
     * id : 165
     * name : 国语
     * pid : 165
     */

    private Integer id;
    private String name;
    private Integer pid;
}
