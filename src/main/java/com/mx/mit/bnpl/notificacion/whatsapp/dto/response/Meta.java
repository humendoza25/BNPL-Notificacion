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
public class Meta implements Serializable {

    @JsonProperty("actions")
    private List<Object> actions;

}
