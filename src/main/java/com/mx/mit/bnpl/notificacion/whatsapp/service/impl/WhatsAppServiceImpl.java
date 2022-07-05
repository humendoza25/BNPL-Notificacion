package com.mx.mit.bnpl.notificacion.whatsapp.service.impl;

import com.mx.mit.bnpl.notificacion.dto.ResponseStruct;
import com.mx.mit.bnpl.notificacion.enums.NotificacionEnum;
import com.mx.mit.bnpl.notificacion.whatsapp.dto.request.Body;
import com.mx.mit.bnpl.notificacion.whatsapp.dto.request.HSM;
import com.mx.mit.bnpl.notificacion.whatsapp.dto.request.WhatsAppRequest;
import com.mx.mit.bnpl.notificacion.whatsapp.enums.WhatsAppEnum;
import com.mx.mit.bnpl.notificacion.whatsapp.service.IWhatsAppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class WhatsAppServiceImpl implements IWhatsAppService {

    @Value("${whats.url.login}")
    private String urlLogin;

    @Value("${whats.url.send}")
    private String urlSend;

    @Value("${whatsapp.user}")
    private String user;

    @Value("${whatsapp.pwd}")
    private String secret;


    @Override
    public ResponseStruct sendOtp(Map<String, Object> params) {
        ResponseStruct response = new ResponseStruct();
        try{
            if(!params.containsKey(NUMERO)
                    || !params.containsKey(OTP)
                    ||"".equals(params.get(NUMERO).toString().trim())
                    || "".equals(params.get(OTP).toString().trim())){

                response.setSuccess(Boolean.FALSE);
                response.setCode(WhatsAppEnum.E_SOLICITUD.getCode());
                response.setMessage(WhatsAppEnum.E_SOLICITUD.getDescription());
                response.setData(null);

            }else{
                Map<String,Object> login = this.token();

                if(!login.isEmpty() && login.containsKey(TOKEN)) {
                    String token = login.get(TOKEN).toString();

                    String numero = params.get(NUMERO).toString().trim();
                    String optCodigo = params.get(OTP).toString().trim();

                    Body body1 = new Body();
                    body1.setType(TYPE_TXT);
                    body1.setValue(APUNTAMELO);

                    Body body2 = new Body();
                    body2.setType(TYPE_TXT);
                    body2.setValue(optCodigo);

                    List<Body> bodies = new ArrayList<>();
                    bodies.add(body1);
                    bodies.add(body2);

                    HSM hsm = new HSM();
                    hsm.setId(NotificacionEnum.N_WA_OTP.getDescription());
                    hsm.setLanguage(ES_MX);
                    hsm.setBody(bodies);

                    WhatsAppRequest whatsAppRequest = new WhatsAppRequest();
                    whatsAppRequest.setExternal_id(numero);
                    whatsAppRequest.setPlatform(WHATSAPP_OFFICIAL);
                    whatsAppRequest.setHsm(hsm);

                    HttpHeaders headers = new HttpHeaders();
                    headers.set("Authorization", "Bearer " + token);

                    HttpEntity<WhatsAppRequest> entity = new HttpEntity<>(whatsAppRequest, headers);

                    RestTemplate restTemplate = new RestTemplate();
                    Map responseWhats = restTemplate.postForObject(urlSend, entity, Map.class);

                    response.setSuccess(Boolean.TRUE);
                    response.setCode(WhatsAppEnum.OK_SEND.getCode());
                    response.setMessage(WhatsAppEnum.OK_SEND.getDescription());
                    response.setData(responseWhats);

                }else{
                    response.setSuccess(Boolean.FALSE);
                    response.setCode(WhatsAppEnum.E_TOKEN.getCode());
                    response.setMessage(WhatsAppEnum.E_TOKEN.getDescription());
                    response.setData(null);
                }
            }

        }catch (Exception e){
            log.error("Error al enviar mensaje otp",e);
            response.setSuccess(Boolean.FALSE);
            response.setCode(WhatsAppEnum.E_SEND.getCode());
            response.setMessage(WhatsAppEnum.E_SEND.getDescription());
            response.setData(null);
        }

        return response;
    }




    private Map token() {
        try{
            Map<String, String> request = new HashMap<>();
            request.put(P_EMAIL, this.user);
            request.put(P_PASSWORD, this.secret);

            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.postForObject(this.urlLogin,request,Map.class);

        }catch (Exception e){
            log.error("Error al obtener Token de WhatsApp",e);
            return  null;
        }
    }
}
