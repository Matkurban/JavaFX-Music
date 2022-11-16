package com.kur.entity.wy;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class HBean implements Serializable {
    /**
     * br : 320002
     * fid : 0
     * size : 7282982
     * vd : -42177
     * sr : 44100
     */

    private Integer br;
    private Integer fid;
    private Integer size;
    private Integer vd;
    private Integer sr;
}
