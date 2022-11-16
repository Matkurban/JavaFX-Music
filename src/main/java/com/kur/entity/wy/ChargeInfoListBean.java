package com.kur.entity.wy;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class ChargeInfoListBean implements Serializable {
    /**
     * rate : 128000
     * chargeUrl : null
     * chargeMessage : null
     * chargeType : 0
     */

    private Integer rate;
    private Object chargeUrl;
    private Object chargeMessage;
    private Integer chargeType;
}
