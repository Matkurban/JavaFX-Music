package com.kur.entity.qq;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class ActionBean implements Serializable {
    /**
     * alert : 2
     * icons : 12992510
     * msgid : 13
     * msgpay : 6
     * switch : 16897281
     */

    private Integer alert;
    private Integer icons;
    private Integer msgid;
    private Integer msgpay;
    private Integer switchX;
}
