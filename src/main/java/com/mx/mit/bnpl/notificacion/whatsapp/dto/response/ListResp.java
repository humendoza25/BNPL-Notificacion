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
public class ListResp implements Serializable {
    @JsonProperty("elements")
    private List<Object> elements;

}
