package com.kur;

import com.kur.app.MediaApp;
import javafx.application.Application;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

public class AppStart {
    public static void main(String[] args) {
        System.setProperty("prism.allowhidpi", "false");
        FileOutputStream fous; // 创建FileOutputStream对象
        FileLock lock; // 创建FileLock对象
        File file = new File(new File("").getAbsolutePath() + "//app.lock");
        try {
            fous = new FileOutputStream(file, true); // 实例化FileOutputStream对象

            lock = fous.getChannel().tryLock(); // 获取文件锁定
            if (lock != null) {
                Application.launch(MediaApp.class, args);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

