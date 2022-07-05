package com.mx.mit.bnpl.notificacion.whatsapp.controller;

import com.mx.mit.bnpl.notificacion.dto.ResponseStruct;
import com.mx.mit.bnpl.notificacion.service.INotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class NotificaWhatsAppController {

    @Autowired
    private INotificacionService notificacionService;

    @PostMapping("/sendws")
    @ResponseStatus(HttpStatus.OK)
    public ResponseStruct sendWhatsApp(@RequestBody Map<String, Object> request){
        return this.notificacionService.sendWhatsApp(request);
    }

}
