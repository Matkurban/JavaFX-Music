package com.kur.entity;

import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Retry;
import com.dtflys.forest.annotation.Var;
import com.kur.pojo.PicUrl;
import com.kur.pojo.RandomImg;


@Retry(maxRetryCount = "5", maxRetryInterval = "10")
public interface MediaMapper {

    @Get(value = "https://myhkw.cn/open/music/search?key={key} &name={name}&type={type}&page=1&limit=50&format=1", connectTimeout = 10000, readTimeout = 10000)
    SourceResult sourceSong(@Var("key") String key, @Var("name") String name, @Var("type") String type);

    @Get(value = "https://myhkw.cn/open/music/list?key={key}&id={uid}&type={type}&format=1", connectTimeout = 10000, readTimeout = 10000)
    Results insertSongList(@Var("key") String key, @Var("uid") String uid, @Var("type") String type);

    @Get(value = "https://myhkw.cn/open/music/info?key={key}&id={songId}&type={type}&pic=1&url=1&lrc=1", connectTimeout = 10000, readTimeout = 10000)
    SongMsg getMusic(@Var("key") String key, @Var("songId") String songId, @Var("type") String type);

    @Get(value = "https://myhkw.cn/open/music/url?key={key}&id={songId}&type={type}", connectTimeout = 10000, readTimeout = 10000)
    SongPic downloadMp3(@Var("key") String key, @Var("songId") String songId, @Var("type") String type);

    @Get(value = "https://myhkw.cn/open/music/list?key={key}&id={listId}&type={type}", connectTimeout = 10000, readTimeout = 10000)
    String listName(@Var("key") String key, @Var("listId") String listId, @Var("type") String type);

    @Get(value = "https://myhkw.cn/open/music/pic?key={key}&id={songId}&type={type}&pic=1&url=1&lrc=1", connectTimeout = 10000, readTimeout = 10000)
    PicUrl getPic(@Var("key") String key, @Var("songId") String songId, @Var("type") String type);

    @Get(value = "https://myhkw.cn/open/img/scen?key={key}&type=json", connectTimeout = 10000, readTimeout = 10000)
    RandomImg randomImg(@Var("key") String key);
}
