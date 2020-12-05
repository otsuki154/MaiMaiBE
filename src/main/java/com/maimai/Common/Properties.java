package com.maimai.Common;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Properties {
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("messages");

	public static String getMsg(String key, String[] strs) {
		String msg = "";
		try {
			msg = RESOURCE_BUNDLE.getString(key);
			StringBuffer sb;
			for (int i = 0; i < strs.length; i++) {
				sb = new StringBuffer();
				sb.append("{");
				sb.append(i);
				sb.append("}");
				msg = msg.replace(sb.toString(), strs[i]);
			}
		} catch (MissingResourceException e) {
			msg = "Not found message";
		}
		return msg;
	}
}
