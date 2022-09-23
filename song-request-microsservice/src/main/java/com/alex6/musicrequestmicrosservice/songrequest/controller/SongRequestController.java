package com.alex6.musicrequestmicrosservice.songrequest.controller;

import com.alex6.musicrequestmicrosservice.songrequest.domain.SongRequest;
import com.alex6.musicrequestmicrosservice.songrequest.service.SongRequestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/song")
@AllArgsConstructor
public class SongRequestController {

    private SongRequestService songRequestService;

    @PostMapping("/request")
    public ResponseEntity<SongRequest> requestMusic(@RequestBody(required = true) SongRequest songRequest) throws JsonProcessingException {
        SongRequest response =  songRequestService.sendSongRequestToQueue(songRequest);
        return ResponseEntity.ok(response);
    }
}
