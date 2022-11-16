package com.kur.entity.wy;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class CreatorBean implements Serializable {
    /**
     * defaultAvatar : false
     * province : 650000
     * authStatus : 0
     * followed : false
     * avatarUrl : http://p1.music.126.net/SUeqMM8HOIpHv9Nhl9qt9w==/109951165647004069.jpg
     * accountStatus : 0
     * gender : 1
     * city : 650100
     * birthday : 0
     * userId : 3903109386
     * userType : 0
     * nickname : 凡是也许你
     * signature :
     * description :
     * detailDescription :
     * avatarImgId : 109951165647004069
     * backgroundImgId : 109951162868128395
     * backgroundUrl : http://p1.music.126.net/2zSNIqTcpHL2jIvU6hG0EA==/109951162868128395.jpg
     * authority : 0
     * mutual : false
     * expertTags : null
     * experts : null
     * djStatus : 0
     * vipType : 0
     * remarkName : null
     * authenticationTypes : 0
     * avatarDetail : null
     * avatarImgIdStr : 109951165647004069
     * backgroundImgIdStr : 109951162868128395
     * anchor : false
     * avatarImgId_str : 109951165647004069
     */

    private Boolean defaultAvatar;
    private Integer province;
    private Integer authStatus;
    private Boolean followed;
    private String avatarUrl;
    private Integer accountStatus;
    private Integer gender;
    private Integer city;
    private Integer birthday;
    private Long userId;
    private Integer userType;
    private String nickname;
    private String signature;
    private String description;
    private String detailDescription;
    private Long avatarImgId;
    private Long backgroundImgId;
    private String backgroundUrl;
    private Integer authority;
    private Boolean mutual;
    private Object expertTags;
    private Object experts;
    private Integer djStatus;
    private Integer vipType;
    private Object remarkName;
    private Integer authenticationTypes;
    private Object avatarDetail;
    private String avatarImgIdStr;
    private String backgroundImgIdStr;
    private Boolean anchor;
}
