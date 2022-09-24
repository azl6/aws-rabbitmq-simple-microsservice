package com.alex6.musicplayermicrosservice.songplayer;

import com.alex6.musicplayermicrosservice.songrequest.domain.SongRequest;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class SongPlayerService {

    private Gson gson;

    @RabbitListener(queues = "q.song-req")
    public void listen(String msg){
        SongRequest songRequest = gson.fromJson(msg, SongRequest.class);

        playSong(songRequest);
    }

    private void playSong(SongRequest songRequest){
        System.out.println("******************************************************");
        System.out.println("Playing " + songRequest.getSong() + "...");
        System.out.println("Requested by: " + songRequest.getRequestedBy());
        System.out.println("******************************************************");
    }
}
