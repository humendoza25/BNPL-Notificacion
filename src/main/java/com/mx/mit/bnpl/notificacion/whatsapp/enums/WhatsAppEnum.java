package com.mx.mit.bnpl.notificacion.whatsapp.enums;

import lombok.Getter;

@Getter
public enum WhatsAppEnum {

    E_SOLICITUD     ("NOT-WA-00", "Solicitud erronea."),
    E_TOKEN         ("NOT-WA-01", "Error autenticaci\u00f3n WhatsApp."),
    OK_SEND         ("NOT-WA-02", "Mensaje enviado."),
    E_SEND          ("NOT-WA-03", "Erro al enviar mensaje.");

    private final String code;
    private final String description;

    WhatsAppEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
