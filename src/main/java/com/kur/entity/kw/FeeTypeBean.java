package com.kur.entity.kw;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class FeeTypeBean implements Serializable {
    /**
     * song : 1
     * vip : 1
     */

    private String song;
    private String vip;
}
