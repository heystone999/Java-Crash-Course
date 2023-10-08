package com.stone.module5.service;

import com.stone.module5.dto.Play;
import com.stone.module5.dto.Video;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Service
public class VideoService1 {
    public VideoService1() {
    }

    Map<String,Video> map=new HashMap<>();

    @PostConstruct
    public void init() {
        try {
            List<String> data = Files.readAllLines(Path.of("data", "p.csv"));

            for (String line : data) {
                String[] s = line.split(",");
                String[] tags = s[7].split("_");

                List<Play> list = getPlaysList(s[0]);
                Video video = new Video(s[0], s[3], LocalDateTime.parse(s[6]), s[4], s[5], Arrays.asList(tags), list, s[1], s[2]);
                map.put(s[0],video);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Video find(String bv) throws IOException {
        /*try {
            List<String> data = Files.readAllLines(Path.of("data", "p.csv"));

            for (String line : data) {
                String[] s = line.split(",");
                if (s[0].equals(bv)) {
                    String[] tags = s[7].split("_");

                    List<Play> list = getPlaysList(bv);

                    return new Video(s[0], s[3], LocalDateTime.parse(s[6]), s[4], s[5], Arrays.asList(tags), list, s[1], s[2]);
                }
            }
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        return map.get(bv);
    }

    //    读取选集文件
    private static List<Play> getPlaysList(String bv) {
        try {
            List<String> vdata = Files.readAllLines(Path.of("data", "v_" + bv + ".csv"));
            List<Play> list = new ArrayList<>();
            for (String vline : vdata) {
                String[] ss = vline.split(",");
                list.add(new Play(ss[0], ss[1], LocalTime.parse(ss[3]), ss[2]));
            }
            return list;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}