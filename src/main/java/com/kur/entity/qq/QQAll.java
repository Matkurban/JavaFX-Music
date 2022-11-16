package com.kur.entity.qq;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class QQAll implements Serializable {

    private Integer code;
    private String msg;
    private DataBeanX data;
}
