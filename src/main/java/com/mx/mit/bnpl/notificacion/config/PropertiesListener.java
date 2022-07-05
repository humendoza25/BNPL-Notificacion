package com.mx.mit.bnpl.notificacion.config;

import com.mx.mit.bnpl.notificacion.secrets.WhatsAppSecrets;
import org.json.JSONObject;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;

import java.util.Properties;


@Component("PropertiesListener")
public class PropertiesListener implements ApplicationListener<ApplicationPreparedEvent> {

	@Override
	public void onApplicationEvent(ApplicationPreparedEvent event) {
		ConfigurableEnvironment env = event.getApplicationContext().getEnvironment();
		Properties props = getPlain();
		env.getPropertySources().addFirst(new PropertiesPropertySource("aws.secret.manager",props));
	}
	
	public Properties getPlain() {
		WhatsAppSecrets whatsAppSecrets = new WhatsAppSecrets();
		JSONObject secretsWA = whatsAppSecrets.get();

		Properties props = new Properties();
		props.put("whatsapp.user", secretsWA.get("whatsapp.userC"));
		props.put("whatsapp.pwd", secretsWA.get("whatsapp.pwdC"));
		props.put("whatsapp.username", secretsWA.get("whatsapp.usernameC"));
		props.put("whatsapp.key", secretsWA.get("whatsapp.key"));
		
		return props;
	}
	
	public Properties getCipherProps() {
		WhatsAppSecrets whatsAppSecrets = new WhatsAppSecrets();

		JSONObject secretsWA = whatsAppSecrets.get();
		
		Properties props = new Properties();
		props.put("whatsapp.user", secretsWA.get("whatsapp.user"));
		props.put("whatsapp.pwd", secretsWA.get("whatsapp.pwd"));
		props.put("whatsapp.username", secretsWA.get("whatsapp.username"));
		props.put("whatsapp.key", secretsWA.get("whatsapp.key"));
		
		return props;
	}
	
}
