package com.sexyhair.demoimitationmovie.common.utils;

import android.util.Log;

/**
 * log日志管理类
 * @author wj
 *
 */
public class Logger {
	/**
	 * 工具类中的log
	 */
	public static final String Log_Utils = "utls";
	
	/**
	 * 网络访问数据的log
	 */
	public static final String Log_NetData = "netdata";
	
	/**
	 * 所有的自定义的view中出现的问题的
	 */
	public static final String Log_View = "customview";
	/**
	 * 所有的自定义的view中出现的问题的
	 */
	public static final String Log_DBData = "dbdata";
	/**
	 * 程序中try出来的异常
	 */
	public static final String Log_TryException= "TryException";
	
	
	
	private static int LOGLEVEL = 7;
	private static int VERBOSE = 1;
	private static int DEBUG = 2;
	private static int INFO = 3;
	private static int WARN = 4;
	private static int ERROR = 5;

	public static void v(String tag, String msg) {
		if (LOGLEVEL > VERBOSE)
			Log.v(tag, msg);
	}

	public static void d(String tag, String msg) {
		if (LOGLEVEL > DEBUG)
			Log.d(tag, msg);
	}

	public static void i(String tag, String msg) {
		if (LOGLEVEL > INFO)
			Log.i(tag, msg);
	}

	public static void w(String tag, String msg) {
		if (LOGLEVEL > WARN)
			Log.w(tag, msg);
	}

	public static void e(String tag, String msg) {
		if (LOGLEVEL > ERROR)
			Log.e(tag, msg);
	}
}
