package com.ecaray.owms.commons.utils;


import com.ecaray.owms.commons.EncryMD5;
import com.ecaray.owms.commons.EncrySHA1;

import java.util.Arrays;

public class EncryptUtil {
	/**
	 * 获取MD5加密后的字符，算法不可以逆
	 * 
	 * @param str
	 * @return
	 */
	public static String md5(String str) {
		return new EncryMD5().getMD5ofStr(str);
	}

	/**
	 * 获取SHA1加密后的字符，算法不可以逆
	 * 
	 * @param str
	 * @return
	 */
	public static String sha1(String str) {
		return new EncrySHA1().getDigestOfString(str.getBytes());
	}

	/**
	 * 对传入token做验证加密
	 *
	 * @param token
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static String md5Token( String token,String timestamp,String nonce) {
		String[] str = { token, timestamp, nonce };
		Arrays.sort(str); // 字典序排序
		String bigStr = str[0] + str[1] + str[2];
		return md5(bigStr);
	}
}
