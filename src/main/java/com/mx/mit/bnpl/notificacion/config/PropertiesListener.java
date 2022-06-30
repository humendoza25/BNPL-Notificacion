package com.mx.mit.bnpl.notificacion.config;

import java.util.Properties;

import org.json.JSONObject;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;

import com.mx.mit.bnpl.notificacion.secrets.MitIdentitySecrets;
import com.mx.mit.bnpl.notificacion.secrets.MongoSecrets;
import com.mx.mit.bnpl.notificacion.secrets.WhatsAppSecrets;


@Component("PropertiesListener")
public class PropertiesListener implements ApplicationListener<ApplicationPreparedEvent> {

	@Override
	public void onApplicationEvent(ApplicationPreparedEvent event) {
		
		
		ConfigurableEnvironment env = event.getApplicationContext().getEnvironment();
		
		Properties props = getPlain();
		
		env.getPropertySources().addFirst(new PropertiesPropertySource("aws.secret.manager",props));
	}
	
	public Properties getPlain() {
		MongoSecrets mongoSecrets = new MongoSecrets();
		MitIdentitySecrets mitIdentitySecrets = new MitIdentitySecrets(); 
		WhatsAppSecrets whatsAppSecrets = new WhatsAppSecrets();
		
		JSONObject secretsMongo = mongoSecrets.get();
		JSONObject secretsMitIdentity = mitIdentitySecrets.get();
		JSONObject secretsWA = whatsAppSecrets.get();
		
		Properties props = new Properties();
		
		props.put("spring.data.mongodb.uri", secretsMongo.get("mongo.uriC"));
		props.put("spring.data.mongodb.username", secretsMongo.get("mongo.userC"));
		props.put("spring.data.mongodb.password", secretsMongo.get("mongo.pwdC"));
		props.put("spring.data.mongodb.database", secretsMongo.get("mongo.keyC"));
		
		props.put("identity.url", secretsMitIdentity.get("identity.urlC"));
		props.put("identity.apitoken", secretsMitIdentity.get("identity.apitokenC"));
		props.put("identity.secret", secretsMitIdentity.get("identity.secretC"));
		props.put("identity.trackid", secretsMitIdentity.get("identity.trackidC"));
		props.put("identity.urltoken", secretsMitIdentity.get("identity.urltokenC"));
		props.put("identity.urlimages", secretsMitIdentity.get("identity.urlimagesC"));
		props.put("identity.urluserinfo", secretsMitIdentity.get("identity.urluserinfoC"));
		props.put("identity.urlscore", secretsMitIdentity.get("identity.urlscoreC"));
		props.put("identity.key", secretsMitIdentity.get("identity.keyC"));
		
		props.put("whatsapp.user", secretsWA.get("whatsapp.userC"));
		props.put("whatsapp.pwd", secretsWA.get("whatsapp.pwdC"));
		props.put("whatsapp.username", secretsWA.get("whatsapp.usernameC"));
		props.put("whatsapp.key", secretsWA.get("whatsapp.keyC"));
		
		return props;
	}
	
	public Properties getCipherProps() {
		MongoSecrets mongoSecrets = new MongoSecrets();
		MitIdentitySecrets mitIdentitySecrets = new MitIdentitySecrets(); 
		WhatsAppSecrets whatsAppSecrets = new WhatsAppSecrets();
		
		JSONObject secretsMongo = mongoSecrets.get();
		JSONObject secretsMitIdentity = mitIdentitySecrets.get();
		JSONObject secretsWA = whatsAppSecrets.get();
		
		Properties props = new Properties();
		
		props.put("spring.data.mongodb.uri", secretsMongo.get("mongo.uri"));
		props.put("spring.data.mongodb.username", secretsMongo.get("mongo.user"));
		props.put("spring.data.mongodb.password", secretsMongo.get("mongo.pwd"));
		props.put("spring.data.mongodb.database", secretsMongo.get("mongo.key"));
		
		props.put("identity.url", secretsMitIdentity.get("identity.url"));
		props.put("identity.apitoken", secretsMitIdentity.get("identity.apitoken"));
		props.put("identity.secret", secretsMitIdentity.get("identity.secret"));
		props.put("identity.trackid", secretsMitIdentity.get("identity.trackid"));
		props.put("identity.urltoken", secretsMitIdentity.get("identity.urltoken"));
		props.put("identity.urlimages", secretsMitIdentity.get("identity.urlimages"));
		props.put("identity.urluserinfo", secretsMitIdentity.get("identity.urluserinfo"));
		props.put("identity.urlscore", secretsMitIdentity.get("identity.urlscore"));
		props.put("identity.key", secretsMitIdentity.get("identity.key"));
		
		props.put("whatsapp.user", secretsWA.get("whatsapp.user"));
		props.put("whatsapp.pwd", secretsWA.get("whatsapp.pwd"));
		props.put("whatsapp.username", secretsWA.get("whatsapp.username"));
		props.put("whatsapp.key", secretsWA.get("whatsapp.key"));
		
		return props;
	}
	
}
