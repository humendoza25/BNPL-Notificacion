package com.mx.mit.bnpl.notificacion.secrets;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.*;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

import java.util.Base64;

@Slf4j
public class WhatsAppSecrets {
	public JSONObject get() {
		JSONObject result;
		String secretName = "mit-bnpl-dev-whatsapp";
		String AWS_Region = "us-east-1";
		AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard().withRegion(AWS_Region).build();

		String decodedBinarySecret;
		GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest().withSecretId(secretName);
		GetSecretValueResult getSecretValueResult   = null;

		try {
			getSecretValueResult = client.getSecretValue(getSecretValueRequest);
		}
		catch (ResourceNotFoundException e) {
			log.error("The requested secret " + secretName + " was not found");
		}
		catch (InvalidRequestException e) {
			log.error("The request was invalid due to: " + e.getMessage());
		}
		catch (InvalidParameterException e) {
			log.error("The request had invalid params: " + e.getMessage());
		}
		
		if (getSecretValueResult.getSecretString() != null) {
			result = new JSONObject(getSecretValueResult.getSecretString());
		} else {
			decodedBinarySecret = String.valueOf( Base64.getDecoder().decode(getSecretValueResult.getSecretBinary()).array() );
			result = new JSONObject(decodedBinarySecret);
		}

		return result;

	}
}
