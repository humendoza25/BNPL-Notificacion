package com.mx.mit.bnpl.notificacion.service.impl;

import com.mx.mit.bnpl.notificacion.dto.ResponseStruct;
import com.mx.mit.bnpl.notificacion.enums.NotificacionEnum;
import com.mx.mit.bnpl.notificacion.service.INotificacionService;
import com.mx.mit.bnpl.notificacion.whatsapp.enums.WhatsAppEnum;
import com.mx.mit.bnpl.notificacion.whatsapp.service.IWhatsAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NotificacionServiceImpl implements INotificacionService {

    @Autowired
    private IWhatsAppService whatsAppService;

    @Override
    public ResponseStruct sendWhatsApp(Map<String, Object> request) {
        ResponseStruct response = new ResponseStruct();

        if(!request.isEmpty() && request.containsKey(NotificacionEnum.N_WA_ID.getDescription())){

            String plantilla = request.get(NotificacionEnum.N_WA_ID.getDescription()).toString();

            if(NotificacionEnum.N_WA_OTP.getDescription().equals(plantilla)){
                //SEND OTP
                response = this.whatsAppService.sendOtp(request);

            }else {

                response.setSuccess(Boolean.FALSE);
                response.setCode(WhatsAppEnum.E_SOLICITUD.getCode());
                response.setMessage(WhatsAppEnum.E_SOLICITUD.getDescription());
                response.setData(null);
            }


        }else {
            response.setSuccess(Boolean.FALSE);
            response.setCode(WhatsAppEnum.E_SOLICITUD.getCode());
            response.setMessage(WhatsAppEnum.E_SOLICITUD.getDescription());
            response.setData(null);
        }

        return response;
    }
}
