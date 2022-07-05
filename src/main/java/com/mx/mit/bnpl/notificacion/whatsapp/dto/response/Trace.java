package com.mx.mit.bnpl.notificacion.whatsapp.dto.response;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Trace implements Serializable {

    @JsonProperty("_id")
    private String id;

    @JsonProperty("event")
    private String event;

    @JsonProperty("title")
    private String title;

    @JsonProperty("info")
    private String info;

    @JsonProperty("date")
    private OffsetDateTime date;

}
