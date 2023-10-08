package com.stone.module5.service;

import com.stone.module5.dto.Play;
import com.stone.module5.dto.Video;
import com.stone.module5.mapper.PlayMapper;
import com.stone.module5.mapper.VideoMapper;
import com.stone.module5.util.Bv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VideoService2 {
    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private PlayMapper playMapper;

    public Video find(String bv) {
        Video video = videoMapper.findByBv(bv);
        if (video == null) {
            return null;
        }

        List<Play> playList = playMapper.findByBv(bv);
        video.setPlayList(playList);
        return video;
    }

    public String publish(Video video) {
        video.setPublishTime(LocalDateTime.now());

        videoMapper.insert(video);

        int id = videoMapper.lastInsertId();
        String bv = Bv.get(id);
        videoMapper.updateBv(bv, id);

        for (Play play : video.getPlayList()) {
            playMapper.insert(play, bv);
        }

        return bv;
    }
}
