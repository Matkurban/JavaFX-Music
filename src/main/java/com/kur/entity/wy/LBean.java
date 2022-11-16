package com.kur.entity.wy;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class LBean implements Serializable {
    /**
     * br : 128002
     * fid : 0
     * size : 2913219
     * vd : -37835
     * sr : 44100
     */

    private Integer br;
    private Integer fid;
    private Integer size;
    private Integer vd;
    private Integer sr;
}
