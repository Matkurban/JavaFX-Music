package com.kur.entity.qq;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class VolumeBean implements Serializable {
    /**
     * gain : 0
     * lra : 0
     * peak : 0
     */

    private Integer gain;
    private Integer lra;
    private Integer peak;
}
