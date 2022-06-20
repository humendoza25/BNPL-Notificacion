package com.mx.mit.bnpl.notificacion.controller;

import com.mx.mit.bnpl.notificacion.dto.ResponseStruct;
import com.mx.mit.bnpl.notificacion.service.IWhatsAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class NotificaWhatsAppController {

    @Autowired
    private IWhatsAppService whatsAppService;

    @PostMapping("/sendOpt")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> sendOpt(@RequestBody Map<String, Object> request){
        return this.whatsAppService.token();
    }

}
