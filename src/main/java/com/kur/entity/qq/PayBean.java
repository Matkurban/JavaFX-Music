package com.kur.entity.qq;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class PayBean implements Serializable {
    /**
     * pay_down : 1
     * pay_month : 1
     * pay_play : 1
     * pay_status : 0
     * price_album : 0
     * price_track : 200
     * time_free : 0
     */

    private Integer payDown;
    private Integer payMonth;
    private Integer payPlay;
    private Integer payStatus;
    private Integer priceAlbum;
    private Integer priceTrack;
    private Integer timeFree;
}
