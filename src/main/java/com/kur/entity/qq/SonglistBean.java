package com.kur.entity.qq;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
public class SonglistBean implements Serializable {
    /**
     * action : {"alert":2,"icons":12992510,"msgid":13,"msgpay":6,"switch":16897281}
     * album : {"id":303121,"mid":"002MUXQn3e56Un","name":"爱一回伤一回","pmid":"002MUXQn3e56Un_1","subtitle":"《情浓半生缘》电视剧插曲","title":"爱一回伤一回"}
     * file : {"b_30s":0,"e_30s":60000,"media_mid":"0006Gw7o34mVOM","size_128":4011772,"size_128mp3":4011772,"size_192aac":6015952,"size_192ogg":5529833,"size_24aac":0,"size_320":10029130,"size_320mp3":10029130,"size_48aac":1514674,"size_96aac":3030932,"size_aac":1514674,"size_ape":0,"size_dts":0,"size_flac":25653276,"size_hires":0,"size_ogg":5529833,"size_try":960887,"try_begin":0,"try_end":0}
     * fnote : 4009
     * genre : 1
     * id : 3580709
     * index_album : 6
     * index_cd : 0
     * interval : 250
     * isonly : 0
     * ksong : {"id":0,"mid":"001nGFYm2ueEeU"}
     * language : 0
     * mid : 003GqODe4J5tXt
     * mv : {"id":211230,"vid":"v00123eolth"}
     * name : 朋友别哭
     * ov : 0
     * pay : {"pay_down":1,"pay_month":1,"pay_play":1,"pay_status":0,"price_album":0,"price_track":200,"time_free":0}
     * sa : 17408
     * singer : [{"id":4904,"mid":"00081ZN91FD8QW","name":"吕方","title":"吕方"}]
     * songtype : 13
     * status : 0
     * subtitle :
     * tid : 0
     * time_public : 1995-05-01
     * title : 朋友别哭
     * type : 0
     * url :
     * volume : {"gain":0,"lra":0,"peak":0}
     * vs : ["064CBZzj1ttwV7","",""]
     */

    private ActionBean action;
    private AlbumBean album;
    private FileBean file;
    private Integer fnote;
    private Integer genre;
    private Integer id;
    private Integer indexAlbum;
    private Integer indexCd;
    private Integer interval;
    private Integer isonly;
    private KsongBean ksong;
    private Integer language;
    private String mid;
    private MvBean mv;
    private String name;
    private Integer ov;
    private PayBean pay;
    private Integer sa;
    private Integer songtype;
    private Integer status;
    private String subtitle;
    private Integer tid;
    private String timePublic;
    private String title;
    private Integer type;
    private String url;
    private VolumeBean volume;
    private List<SingerBean> singer;
    private List<String> vs;
}
