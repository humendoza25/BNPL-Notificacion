package com.mx.mit.bnpl.notificacion.enums;

import lombok.Getter;

@Getter
public enum NotificacionEnum {

    N_WA_ID("id"),
    N_WA_OTP ("cdigo_otp");

    private final String description;

    NotificacionEnum(String description) {
        this.description = description;
    }
}
