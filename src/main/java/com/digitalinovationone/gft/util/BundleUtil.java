package com.digitalinovationone.gft.util;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class BundleUtil {
	
	public static String getText(String key, Object... args) {
		ResourceBundle bundle = ResourceBundle.getBundle("bundle",new Locale("pt","BR"));
		
		try {
			return MessageFormat.format(bundle.getString(key), args);
		} catch( Exception e) {
			return key;
		}
	}


	public static String ISOtoUF8(String str) {
		Charset utf8charset = Charset.forName("UTF-8");
		Charset iso88591charset = Charset.forName("ISO-8859-1");

		ByteBuffer inputBuffer = ByteBuffer.wrap(str.getBytes());

		// decode UTF-8
		CharBuffer data = iso88591charset.decode(inputBuffer);

		// encode ISO-8559-1
		ByteBuffer outputBuffer = utf8charset.encode(data);
		byte[] outputData = outputBuffer.array();

		return new String(outputData);

	}
}
