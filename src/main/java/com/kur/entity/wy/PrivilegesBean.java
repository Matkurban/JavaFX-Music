package com.kur.entity.wy;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
public class PrivilegesBean implements Serializable {
    /**
     * id : 1959166451
     * fee : 8
     * payed : 0
     * realPayed : 0
     * st : 0
     * pl : 128000
     * dl : 0
     * sp : 7
     * cp : 1
     * subp : 1
     * cs : false
     * maxbr : 999000
     * fl : 128000
     * pc : null
     * toast : false
     * flag : 2
     * paidBigBang : false
     * preSell : false
     * playMaxbr : 999000
     * downloadMaxbr : 999000
     * maxBrLevel : lossless
     * playMaxBrLevel : lossless
     * downloadMaxBrLevel : lossless
     * plLevel : standard
     * dlLevel : none
     * flLevel : standard
     * rscl : null
     * freeTrialPrivilege : {"resConsumable":false,"userConsumable":false,"listenType":null}
     * chargeInfoList : [{"rate":128000,"chargeUrl":null,"chargeMessage":null,"chargeType":0},{"rate":192000,"chargeUrl":null,"chargeMessage":null,"chargeType":1},{"rate":320000,"chargeUrl":null,"chargeMessage":null,"chargeType":1},{"rate":999000,"chargeUrl":null,"chargeMessage":null,"chargeType":1}]
     */

    private Integer id;
    private Integer fee;
    private Integer payed;
    private Integer realPayed;
    private Integer st;
    private Integer pl;
    private Integer dl;
    private Integer sp;
    private Integer cp;
    private Integer subp;
    private Boolean cs;
    private Integer maxbr;
    private Integer fl;
    private Object pc;
    private Boolean toast;
    private Integer flag;
    private Boolean paidBigBang;
    private Boolean preSell;
    private Integer playMaxbr;
    private Integer downloadMaxbr;
    private String maxBrLevel;
    private String playMaxBrLevel;
    private String downloadMaxBrLevel;
    private String plLevel;
    private String dlLevel;
    private String flLevel;
    private Object rscl;
    private FreeTrialPrivilegeBean freeTrialPrivilege;
    private List<ChargeInfoListBean> chargeInfoList;
}
