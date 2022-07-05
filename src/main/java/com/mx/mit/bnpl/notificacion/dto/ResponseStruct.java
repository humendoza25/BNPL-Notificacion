package com.mx.mit.bnpl.notificacion.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <h2>ResponseStruct</h2>
 * <pre>
 *     POJO para el env&iacute;o de respuestas de los
 *     servicios REST.
 * </pre>
 *
 * @author maverick
 * @version 1.0
 * @since Junio 2022
 */
@Data
public class ResponseStruct implements Serializable {
	private boolean success;
	private String message;
	private String code;
	private Object data;
}
