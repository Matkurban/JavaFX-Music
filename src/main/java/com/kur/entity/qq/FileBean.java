package com.kur.entity.qq;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class FileBean implements Serializable {
    /**
     * b_30s : 0
     * e_30s : 60000
     * media_mid : 0006Gw7o34mVOM
     * size_128 : 4011772
     * size_128mp3 : 4011772
     * size_192aac : 6015952
     * size_192ogg : 5529833
     * size_24aac : 0
     * size_320 : 10029130
     * size_320mp3 : 10029130
     * size_48aac : 1514674
     * size_96aac : 3030932
     * size_aac : 1514674
     * size_ape : 0
     * size_dts : 0
     * size_flac : 25653276
     * size_hires : 0
     * size_ogg : 5529833
     * size_try : 960887
     * try_begin : 0
     * try_end : 0
     */

    private Integer b30s;
    private Integer e30s;
    private String mediaMid;
    private Integer size128;
    private Integer size128mp3;
    private Integer size192aac;
    private Integer size192ogg;
    private Integer size24aac;
    private Integer size320;
    private Integer size320mp3;
    private Integer size48aac;
    private Integer size96aac;
    private Integer sizeAac;
    private Integer sizeApe;
    private Integer sizeDts;
    private Integer sizeFlac;
    private Integer sizeHires;
    private Integer sizeOgg;
    private Integer sizeTry;
    private Integer tryBegin;
    private Integer tryEnd;
}
