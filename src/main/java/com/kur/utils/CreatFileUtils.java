package com.kur.utils;


import java.io.File;
import java.io.IOException;

/**
 * @author Kurban
 */
public class CreatFileUtils {


    /**
     * 写入数据路径
     *
     * @return {@link File}
     */
    public static File writeDataPath() {
        File file = new File(new File("").getAbsolutePath() + "//user");
        if (!file.exists()) file.mkdirs();
        File music = new File(file + File.separator + "music");
        try {
            if (!music.exists()) music.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return music;
    }
}
