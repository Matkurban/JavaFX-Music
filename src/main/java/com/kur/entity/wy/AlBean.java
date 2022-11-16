package com.kur.entity.wy;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
public class AlBean implements Serializable {
    /**
     * id : 147119318
     * name : TERAK
     * picUrl : http://p4.music.126.net/0YbR7l4ApfbLK6J7WqGMjw==/109951167592178430.jpg
     * tns : []
     * pic_str : 109951167592178430
     * pic : 109951167592178430
     */

    private Integer id;
    private String name;
    private String picUrl;
    private String picStr;
    private Long pic;
    private List<?> tns;
}
