package com.alex6.songlogspersistencemicrosservice.songlogs.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "song_request_logs")
public class SongRequestLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Long logId;

    @Column(name = "requested_by")
    private String requestedBy;

    @Column(name = "song")
    private String song;

    @Column(name = "request_date")
    private Date requestDate;

}
