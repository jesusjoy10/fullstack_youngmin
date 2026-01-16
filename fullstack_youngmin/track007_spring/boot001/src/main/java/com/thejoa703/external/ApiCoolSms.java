package com.thejoa703.external;

import java.util.HashMap;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Component
public class ApiCoolSms {
	
	@Value("${coolsms.apikey}")
	String api_key;
	@Value("${coolsms.apisecret}")
	String api_secret;
	
	public String phoneNumber(String to) throws CoolsmsException { 
		//1. random 숫자 메세지 만들기
		Random random = new Random();
		String number = String.format("%06d", random.nextInt(1000000)); 
		//2. 메세지 보내기
		//net.nurigo.java_sdk.api.Message;
		Message message = new Message(api_key, api_secret);
		HashMap<String,String>params = new HashMap<String,String>();
		params.put("to", to);
		params.put("from", to);
		params.put("type", "SMS");
		params.put("text", "[THEJOA] 인증번호: ["+number+"] 타인 유출로 인한 피해 주의");
		message.send(params);
	
		return number;
		
	}

}
