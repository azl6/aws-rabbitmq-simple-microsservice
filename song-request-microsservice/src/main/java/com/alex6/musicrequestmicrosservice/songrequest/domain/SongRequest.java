package com.alex6.musicrequestmicrosservice.songrequest.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class SongRequest implements Serializable {

    private String requestedBy;
    private String song;

}
