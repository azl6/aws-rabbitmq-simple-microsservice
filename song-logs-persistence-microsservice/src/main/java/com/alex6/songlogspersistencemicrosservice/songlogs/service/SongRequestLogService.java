package com.alex6.songlogspersistencemicrosservice.songlogs.service;

import com.alex6.songlogspersistencemicrosservice.songlogs.domain.SongRequestLog;
import com.alex6.songlogspersistencemicrosservice.songlogs.repository.SongRequestLogRepository;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class SongRequestLogService {

    private SongRequestLogRepository songRequestLogRepository;
    private Gson gson;

    public List<SongRequestLog> findAllLogs(){
        return songRequestLogRepository.findAll();
    }

    @RabbitListener(queues = "q.song-logs")
    public void saveSongLog(String msg){
        SongRequestLog logToBeSaved = setUpLog(msg);
        songRequestLogRepository.save(logToBeSaved);
        System.out.println("Requested song " + logToBeSaved.getSong() +" by " + logToBeSaved.getRequestedBy() + " saved sucessfully!");
    }

    public SongRequestLog setUpLog(String msg){
        var settedUpLog = gson.fromJson(msg, SongRequestLog.class);
        settedUpLog.setRequestDate(Date.from(Instant.now()));
        return settedUpLog;
    }
}
