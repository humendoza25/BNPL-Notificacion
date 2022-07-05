package com.mx.mit.bnpl.notificacion.whatsapp.dto.response;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payload implements Serializable {

    @JsonProperty("removed")
    private List<Object> removed;

    @JsonProperty("added")
    private List<Object> added;

}
