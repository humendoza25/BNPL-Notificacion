package com.mx.mit.bnpl.notificacion.service;

import com.mx.mit.bnpl.notificacion.dto.ResponseStruct;

import java.util.Map;

public interface INotificacionService {

    ResponseStruct sendWhatsApp(Map<String, Object> request);

}
