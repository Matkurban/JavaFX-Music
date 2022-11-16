package com.kur.entity.kw;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class MusicListBean implements Serializable {
    /**
     * musicrid : MUSIC_141734335
     * barrage : 0
     * ad_type :
     * artist : 刘仲威
     * mvpayinfo : {"play":0,"vid":17017428,"down":0}
     * pic : https://img3.kuwo.cn/star/albumcover/500/60/6/1060687846.jpg
     * isstar : 0
     * rid : 141734335
     * duration : 231
     * score100 : 40
     * ad_subtype : 0
     * content_type : 0
     * track : 1
     * hasLossless : true
     * hasmv : 0
     * releaseDate : 2020-05-31
     * album : 晚安，从前
     * albumid : 14260938
     * pay : 16515324
     * artistid : 5283055
     * albumpic : https://img3.kuwo.cn/star/albumcover/500/60/6/1060687846.jpg
     * originalsongtype : 0
     * songTimeMinutes : 03:51
     * isListenFee : false
     * pic120 : https://img3.kuwo.cn/star/albumcover/120/60/6/1060687846.jpg
     * name : 晚安，从前
     * online : 1
     * payInfo : {"play":"1100","nplay":"00111","overseas_nplay":"00111","local_encrypt":"1","limitfree":0,"refrain_start":56000,"feeType":{"song":"1","vip":"1"},"down":"1111","ndown":"11111","download":"1111","cannotDownload":0,"overseas_ndown":"11111","refrain_end":95000,"cannotOnlinePlay":0}
     * tme_musician_adtype : 1
     */

    private String musicrid;
    private String barrage;
    private String adType;
    private String artist;
    private MvpayinfoBean mvpayinfo;
    private String pic;
    private Integer isstar;
    private Integer rid;
    private Integer duration;
    private String score100;
    private String adSubtype;
    private String contentType;
    private Integer track;
    private Boolean hasLossless;
    private Integer hasmv;
    private String releaseDate;
    private String album;
    private Integer albumid;
    private String pay;
    private Integer artistid;
    private String albumpic;
    private Integer originalsongtype;
    private String songTimeMinutes;
    private Boolean isListenFee;
    private String pic120;
    private String name;
    private Integer online;
    private PayInfoBean payInfo;
    private String tmeMusicianAdtype;
}
