package org.bedoing.blog.security;

public class EndecryptUtil {
	private static final String SPKEY = "test";
	/**
	 * 加密
	 * @param oldStr
	 * @return
	 */
	public static String encrypt(String oldStr){
		Endecrypt endecrypt = new Endecrypt();
		String newStr = endecrypt.get3DESEncrypt(oldStr, SPKEY);
		return newStr.trim().intern();
	}
	
	/**
	 * 解密
	 * @param oldStr
	 * @return
	 */
	public static String decrypt(String oldStr){
		Endecrypt decrypt = new Endecrypt();
		return decrypt.get3DESDecrypt(oldStr, SPKEY);
	}
}
