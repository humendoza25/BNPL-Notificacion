package com.mx.mit.bnpl.notificacion.whatsapp.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HSM {
    @JsonProperty("id")
    private String id;

    @JsonProperty("language")
    private String language;

    @JsonProperty("body")
    private List<Body> body;
}