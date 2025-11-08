package com.intr.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESCryptoUtil {
	
	private static final String KEY_STRING = "ThisIsASecretKey"; // 16자리 고정 키
	private static final String IV_STRING = "FixedIVForAES128";   // 16자리 고정 IV
	
	// 시크릿 키 반환 (수정)
    public static SecretKey getKey() throws Exception {
    	return new SecretKeySpec(KEY_STRING.getBytes(StandardCharsets.UTF_8), "AES");
    }
	
    // 초기화 벡터 (IV) 반환
    public static IvParameterSpec getIv() {
    	return new IvParameterSpec(IV_STRING.getBytes(StandardCharsets.UTF_8));
    }
    
    // 암호화 처리
    public static String encrypt(String specName, SecretKey key, IvParameterSpec iv, String plainText) throws Exception {
    	// 인스턴스 생성
		Cipher cipher = Cipher.getInstance(specName);																// 암호화 방식
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);																	// 암호화
		byte[] encrypted = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));		// 암호화 처리
		return new String(Base64.getEncoder().encode(encrypted));											// 인코딩 후 반환
	}

    // 복호화 처리
	public static String decrypt(String specName, SecretKey key, IvParameterSpec iv, String cipherText) throws Exception {
		// 인스턴스 생성
		Cipher cipher = Cipher.getInstance(specName);																// 복호화 방식
		cipher.init(Cipher.DECRYPT_MODE, key, iv); 																	// 복호화 
		byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(cipherText));				// 복호화 처리
		return new String(decrypted, StandardCharsets.UTF_8);												// 인코딩 후 반환
	}
}
