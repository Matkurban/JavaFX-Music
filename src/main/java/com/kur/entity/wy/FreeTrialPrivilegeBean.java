package com.kur.entity.wy;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class FreeTrialPrivilegeBean implements Serializable {
    /**
     * resConsumable : false
     * userConsumable : false
     * listenType : null
     */

    private Boolean resConsumable;
    private Boolean userConsumable;
    private Object listenType;
}
