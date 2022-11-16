package com.kur.entity.wy;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
public class TracksBean implements Serializable {
    /**
     * name : TERAK
     * id : 1959166451
     * pst : 0
     * t : 0
     * ar : [{"id":30000828,"name":"海瓦斯Hawvas","tns":[],"alias":[]},{"id":13153900,"name":"Sarkar","tns":[],"alias":[]},{"id":12275142,"name":"MESHEL","tns":[],"alias":[]}]
     * alia : []
     * pop : 100
     * st : 0
     * rt :
     * fee : 8
     * v : 9
     * crbt : null
     * cf :
     * al : {"id":147119318,"name":"TERAK","picUrl":"http://p4.music.126.net/0YbR7l4ApfbLK6J7WqGMjw==/109951167592178430.jpg","tns":[],"pic_str":"109951167592178430","pic":109951167592178430}
     * dt : 182000
     * h : {"br":320002,"fid":0,"size":7282982,"vd":-42177,"sr":44100}
     * m : {"br":192002,"fid":0,"size":4369807,"vd":-39569,"sr":44100}
     * l : {"br":128002,"fid":0,"size":2913219,"vd":-37835,"sr":44100}
     * sq : {"br":1437313,"fid":0,"size":32698883,"vd":-42177,"sr":44100}
     * hr : null
     * a : null
     * cd : 01
     * no : 1
     * rtUrl : null
     * ftype : 0
     * rtUrls : []
     * djId : 0
     * copyright : 0
     * s_id : 0
     * mark : 64
     * originCoverType : 0
     * originSongSimpleData : null
     * tagPicList : null
     * resourceState : true
     * version : 9
     * songJumpInfo : null
     * entertainmentTags : null
     * single : 0
     * noCopyrightRcmd : null
     * rtype : 0
     * rurl : null
     * mst : 9
     * cp : 0
     * mv : 0
     * publishTime : 0
     * tns : ["局外人"]
     */

    private String name;
    private Integer id;
    private Integer pst;
    private Integer t;
    private Integer pop;
    private Integer st;
    private String rt;
    private Integer fee;
    private Integer v;
    private Object crbt;
    private String cf;
    private AlBean al;
    private Integer dt;
    private HBean h;
    private MBean m;
    private LBean l;
    private SqBean sq;
    private Object hr;
    private Object a;
    private String cd;
    private Integer no;
    private Object rtUrl;
    private Integer ftype;
    private Integer djId;
    private Integer copyright;
    private Integer sId;
    private long mark;
    private Integer originCoverType;
    private Object originSongSimpleData;
    private Object tagPicList;
    private Boolean resourceState;
    private Integer version;
    private Object songJumpInfo;
    private Object entertainmentTags;
    private Integer single;
    private Object noCopyrightRcmd;
    private Integer rtype;
    private Object rurl;
    private Integer mst;
    private Integer cp;
    private Integer mv;
    private long publishTime;
    private List<ArBean> ar;
    private List<?> alia;
    private List<?> rtUrls;
    private List<String> tns;
}
