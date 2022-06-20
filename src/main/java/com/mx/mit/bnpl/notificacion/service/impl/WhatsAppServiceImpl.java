package com.mx.mit.bnpl.notificacion.service.impl;

import com.mx.mit.bnpl.notificacion.dto.ResponseStruct;
import com.mx.mit.bnpl.notificacion.enums.WhatsAppEnum;
import com.mx.mit.bnpl.notificacion.service.IWhatsAppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class WhatsAppServiceImpl implements IWhatsAppService {

    @Value("${whats.url.login}")
    private String urlLogin;

    @Value("${whats.user}")
    private String user;

    @Value("${whats.secret}")
    private String secret;


    @Override
    public Map<String, Object> token() {
        try{
            Map<String, String> request = new HashMap<>();
            request.put(WhatsAppEnum.P_EMAIL.getDescription(), this.user);
            request.put(WhatsAppEnum.P_PASSWORD.getDescription(), this.secret);

            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.postForObject(this.urlLogin,request,Map.class);

        }catch (Exception e){
            log.error("Error al obtener Token de WhatsApp",e);
            return  null;
        }
    }


    @Override
    public ResponseStruct sendOtp(Map<String, Object> params) {
        try{
            Map<String,Object> login = this.token();

            if(login!=null && login.containsKey("token")){
                String token = login.get("token").toString();




            }else{

            }

        }catch (Exception e){

        }

        return null;
    }
}
