package com.mx.mit.bnpl.notificacion.whatsapp.dto.response;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WhatsAppResponse  implements Serializable {
    @JsonProperty("success")
    private boolean success;

    @JsonProperty("result")
    private Result result;

}
