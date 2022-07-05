package com.mx.mit.bnpl.notificacion.whatsapp.service;

import com.mx.mit.bnpl.notificacion.dto.ResponseStruct;

import java.util.Map;

public interface IWhatsAppService {

    /* Para obtencion de token*/
    String P_EMAIL = "email";
    String P_PASSWORD = "password";

    /* Para OTP*/
    String NUMERO = "numero";
    String OTP = "otp";
    String TOKEN = "token";
    String WHATSAPP_OFFICIAL = "whatsapp_official";
    String ES_MX = "es_MX";
    String TYPE_TXT = "text";
    String APUNTAMELO = "Ap\u00fantamelo";


    ResponseStruct sendOtp(Map<String, Object>params);

}
