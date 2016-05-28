package com.mydroid.oschina.util;

import java.io.Closeable;
import java.io.IOException;

public class IOUtils {
	/** 关闭流 */
	public static boolean close(Closeable io) {
		if (io != null) {
			try {
				io.close();
			} catch (IOException e) {
				TLog.error(e.getMessage());
			}
		}
		return true;
	}
}
