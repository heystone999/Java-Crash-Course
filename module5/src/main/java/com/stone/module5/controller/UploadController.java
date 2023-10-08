package com.stone.module5.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

@Controller
public class UploadController {
    @Value("${video-path}")
    private String videoPath;
    @Value("${img-path}")
    private String imgPath;

    @RequestMapping("/upload")
    @ResponseBody
    public Map<String, String> upload(int i, int chunks, MultipartFile data, String url) throws IOException {
        System.out.println(i + " " + chunks + " " + url);

        data.transferTo(Path.of(videoPath, url + ".part" + i));
        return Map.of(url, (i * 100.0 / chunks) + "%");
    }

    @RequestMapping("/finish")
    @ResponseBody
    public void finish(int chunks, String url) throws IOException {
        try (FileOutputStream os = new FileOutputStream(videoPath + url)) {
            for (int i = 1; i <= chunks; i++) {
                Path part = Path.of(videoPath, url + ".part" + i);
                Files.copy(part,os);
                part.toFile().delete();
            }
        }
    }

    @RequestMapping("/uploadCover")
    @ResponseBody
    public Map<String,String >uploadCover(MultipartFile data,String cover) throws IOException {
        data.transferTo(Path.of(imgPath,cover));
        return Map.of("cover",cover);
    }

}

