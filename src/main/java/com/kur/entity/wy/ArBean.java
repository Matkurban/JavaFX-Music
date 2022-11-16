package com.kur.entity.wy;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
public class ArBean implements Serializable {
    /**
     * id : 30000828
     * name : 海瓦斯Hawvas
     * tns : []
     * alias : []
     */

    private Integer id;
    private String name;
    private List<?> tns;
    private List<?> alias;
}
