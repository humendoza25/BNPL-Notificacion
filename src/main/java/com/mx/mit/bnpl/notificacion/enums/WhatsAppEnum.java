package com.mx.mit.bnpl.notificacion.enums;

import lombok.Getter;

@Getter
public enum WhatsAppEnum {

    P_EMAIL     (0, "email"),
    P_PASSWORD  (0, "password");

    private final int code;
    private final String description;

    WhatsAppEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
