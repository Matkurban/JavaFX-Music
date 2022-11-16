package com.kur.entity.kw;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class PayInfoBean implements Serializable {
    /**
     * play : 1100
     * nplay : 00111
     * overseas_nplay : 00111
     * local_encrypt : 1
     * limitfree : 0
     * refrain_start : 56000
     * feeType : {"song":"1","vip":"1"}
     * down : 1111
     * ndown : 11111
     * download : 1111
     * cannotDownload : 0
     * overseas_ndown : 11111
     * refrain_end : 95000
     * cannotOnlinePlay : 0
     */

    private String play;
    private String nplay;
    private String overseasNplay;
    private String localEncrypt;
    private Integer limitfree;
    private Integer refrainStart;
    private FeeTypeBean feeType;
    private String down;
    private String ndown;
    private String download;
    private Integer cannotDownload;
    private String overseasNdown;
    private Integer refrainEnd;
    private Integer cannotOnlinePlay;
}
