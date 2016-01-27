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
	
	/*public static void main(String[] args) {
		System.out.println(encrypt("com.mysql.jdbc.Driver"));
		System.out.println(encrypt("jdbc:mysql://localhost:3306/kendb?useUnicode=true&characterEncoding=utf8"));
		System.out.println(encrypt("root"));
		System.out.println(encrypt("Lxy"));
		System.out.println(encrypt("admin1234"));
	}*/
}
