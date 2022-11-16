package com.kur.entity.wy;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class MBean implements Serializable {
    /**
     * br : 192002
     * fid : 0
     * size : 4369807
     * vd : -39569
     * sr : 44100
     */

    private Integer br;
    private Integer fid;
    private Integer size;
    private Integer vd;
    private Integer sr;
}
