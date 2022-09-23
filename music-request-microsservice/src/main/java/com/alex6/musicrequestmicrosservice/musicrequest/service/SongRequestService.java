package com.alex6.musicrequestmicrosservice.musicrequest.service;

import com.alex6.musicrequestmicrosservice.musicrequest.domain.SongRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SongRequestService {

    private RabbitTemplate rabbitTemplate;
    private ObjectMapper objectMapper;

    public SongRequest sendSongRequestToQueue(SongRequest songRequest) throws JsonProcessingException {
        var json = objectMapper.writeValueAsString(songRequest);
        rabbitTemplate.convertAndSend("x.song-req", "", json);
        return songRequest;
    }
}
