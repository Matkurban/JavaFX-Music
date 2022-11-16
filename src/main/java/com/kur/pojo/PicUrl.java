package com.kur.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PicUrl {
    /**
     * code : 1
     * msg : 获取成功
     * data : https://y.gtimg.cn/music/photo_new/T002R300x300M000004YBQ4346867J.jpg?max_age=2592000
     */

    private Integer code;
    private String msg;
    private String data;
}
