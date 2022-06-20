package com.mx.mit.bnpl.notificacion.service;

import com.mx.mit.bnpl.notificacion.dto.ResponseStruct;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

public interface IWhatsAppService {

    Map<String,Object> token();

    ResponseStruct sendOtp(Map<String, Object>params);

}
