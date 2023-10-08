package com.stone.module5.controller;

import com.stone.module5.dto.Play;
import com.stone.module5.dto.Video;
import com.stone.module5.service.VideoService1;
import com.stone.module5.service.VideoService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Controller
public class VideoController {
    @RequestMapping("/video/{bv}")
    @ResponseBody
    public Video t(@PathVariable String bv) throws IOException {
        /*if (bv.equals("1")) {
            List<Play> plays = List.of(
                    new Play("P1", "二分查找-演示", LocalTime.parse("00:05:46"), "1_1.mp4"),
                    new Play("P2", "二分查找-实现", LocalTime.parse("00:06:47"), "1_2.mp4")
            );

            return new Video("1", "面试专题-基础篇", LocalDateTime.now(), "1.png", "祝你面试顺利", List.of("面试", "Java", "计算机技术"), plays, "自制", "科技->计算机技术");
        }

        if (bv.equals("2")) {
            List<Play> plays = List.of(
                    new Play("P1", "Java中的线程状态", LocalTime.parse("00:09:45"), "2_1.mp4"),
                    new Play("P2", "代码演示1", LocalTime.parse("00:07:05"), "2_2.mp4"),
                    new Play("P3", "代码演示2", LocalTime.parse("00:05:01"), "2_3.mp4")
            );
            return new Video("2", "面试专题-并发篇", LocalDateTime.now(), "2.png", "祝你面试顺利", List.of("面试", "Java", "计算机技术"), plays, "自制", "科技->计算机技术");
        }
        return null;*/
        return videoService2.find(bv);
    }

    @Autowired
    private VideoService1 videoService1;

    @Autowired
    private VideoService2 videoService2;

    /*@RequestMapping("/video/1")
    @ResponseBody
    public Video t1(){
        List<Play> plays = List.of(
                new Play("P1", "二分查找-演示", LocalTime.parse("00:05:46"), "1_1.mp4"),
                new Play("P2", "二分查找-实现", LocalTime.parse("00:06:47"), "1_2.mp4")
        );

        return new Video("1","面试专题-基础篇", LocalDateTime.now(),"1.png","祝你面试顺利", List.of("面试","Java","计算机技术"),plays,"自制","科技->计算机技术");
    }

    @RequestMapping("/video/2")
    @ResponseBody
    public Video t2(){
        List<Play> plays = List.of(
                new Play("P1", "Java中的线程状态", LocalTime.parse("00:09:45"), "2_1.mp4"),
                new Play("P2", "代码演示1", LocalTime.parse("00:07:05"), "2_2.mp4"),
                new Play("P3", "代码演示2", LocalTime.parse("00:05:01"), "2_3.mp4")
        );
        return new Video("2","面试专题-并发篇", LocalDateTime.now(),"2.png","祝你面试顺利", List.of("面试","Java","计算机技术"),plays,"自制","科技->计算机技术");
    }*/


    @RequestMapping("/publish")
    @ResponseBody
    public Map<String,String> publish(@RequestBody Video video){
        String bv = videoService2.publish(video);
        return Map.of("bv",bv);
    }
}
