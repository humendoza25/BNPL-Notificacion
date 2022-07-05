package com.mx.mit.bnpl.notificacion.whatsapp.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Body implements Serializable {
    @JsonProperty("type")
    private String type;
    @JsonProperty("value")
    private String value;
}
