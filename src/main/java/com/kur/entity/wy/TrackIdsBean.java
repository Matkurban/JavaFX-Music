package com.kur.entity.wy;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class TrackIdsBean implements Serializable {
    /**
     * id : 1959166451
     * v : 9
     * t : 0
     * at : 1659584805731
     * alg : null
     * uid : 3903109386
     * rcmdReason :
     * sc : null
     */

    private Integer id;
    private Integer v;
    private Integer t;
    private Long at;
    private Object alg;
    private Long uid;
    private String rcmdReason;
    private Object sc;
}
