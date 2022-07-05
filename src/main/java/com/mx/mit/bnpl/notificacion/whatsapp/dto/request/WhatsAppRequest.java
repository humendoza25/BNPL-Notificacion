package com.mx.mit.bnpl.notificacion.whatsapp.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WhatsAppRequest {

    @JsonProperty("external_id")
    private String external_id;

    @JsonProperty("platform")
    private String platform;

    @JsonProperty("hsm")
    private HSM hsm;

}