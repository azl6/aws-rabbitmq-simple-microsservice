package com.alex6.songlogspersistencemicrosservice.songlogs.controller;

import com.alex6.songlogspersistencemicrosservice.songlogs.domain.SongRequestLog;
import com.alex6.songlogspersistencemicrosservice.songlogs.service.SongRequestLogService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logs")
@AllArgsConstructor
public class SongRequestLogController {

    private SongRequestLogService songRequestLogService;

    @GetMapping("/all")
    private ResponseEntity<List<SongRequestLog>> findAllLogs(){
        return ResponseEntity.ok(songRequestLogService.findAllLogs());
    }
}
