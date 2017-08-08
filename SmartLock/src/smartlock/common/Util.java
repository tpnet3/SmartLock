package smartlock.common;

import org.apache.commons.codec.binary.Base64;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {

	/**
	 * 비밀번호 암호화
	 * @param value 암호화할 문자열
	 * @return 암호화된 문자열
	 */
	public static String encrypt(String value) {
		/*
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(value.getBytes(StandardCharsets.UTF_8));
			System.out.println(new String(Base64.encodeBase64(hash)).length());
			return new String(Base64.encodeBase64(hash));
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
		*/

		return new String(Base64.encodeBase64(value.getBytes()));
	}
}
