package com.stone.module5;

import com.stone.module5.dto.Video;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class TestFile {
    public static void main(String[] args) throws IOException {
        List<String> data = Files.readAllLines(Path.of("data", "p.csv"));

        for (String line : data) {
//            System.out.println(line);
            String[] s = line.split(",");
            String[] tags = s[7].split("_");
            System.out.println(s[0]+" "+s[6]+" "+tags[0]+" "+tags[1]);
            new Video(s[0],s[3], LocalDateTime.parse(s[6]),s[4],s[5], Arrays.asList(tags),List.of(),s[1],s[2]);
        }
    }
}
