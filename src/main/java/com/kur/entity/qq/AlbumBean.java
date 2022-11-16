package com.kur.entity.qq;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class AlbumBean implements Serializable {
    /**
     * id : 303121
     * mid : 002MUXQn3e56Un
     * name : 爱一回伤一回
     * pmid : 002MUXQn3e56Un_1
     * subtitle : 《情浓半生缘》电视剧插曲
     * title : 爱一回伤一回
     */

    private Integer id;
    private String mid;
    private String name;
    private String pmid;
    private String subtitle;
    private String title;
}
