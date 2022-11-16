package com.kur.pojo;

import com.kur.entity.Results;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TwoObject {

    private Results results;
    private SongList songList;


}
