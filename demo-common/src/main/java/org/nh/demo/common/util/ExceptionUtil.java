package org.nh.demo.common.util;


public class ExceptionUtil {

	private ExceptionUtil() {
		super();
	}

	public static String parseStackTrace(Throwable e) {
		StringBuilder builder = new StringBuilder();
		if (e != null) {
			builder.append(e.toString());
			builder.append('\n');
			for (int i = 0; i < e.getStackTrace().length; i++) {
				builder.append(e.getStackTrace()[i]);
				builder.append('\n');
			}
		}
		return builder.toString();
	}

}
