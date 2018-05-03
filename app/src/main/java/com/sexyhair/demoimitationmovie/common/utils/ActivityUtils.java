package com.sexyhair.demoimitationmovie.common.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * 关于界面跳转的
 * 
 * @author wj
 * 
 */
public class ActivityUtils {

	public static void jumpTo(Activity activity,
                              Class<? extends Activity> targetActivity, boolean isFinish) {
		if (activity == null) {
			Logger.e(Logger.Log_Utils,
					"参数传入错误-ActivityUtils.java--jumpTo(3)的第一个参数");
			return;
		}
		if (targetActivity == null) {
			Logger.e(Logger.Log_Utils,
					"参数传入错误-ActivityUtils.java--jumpTo(3)的第二个个参数");
			return;
		}
		Intent intent = new Intent(activity, targetActivity);
		activity.startActivity(intent);
		if (isFinish) {
			// true,那就是关闭
			activity.finish();
		}
	}

	public static void jumpTo(Activity activity,
                              Class<? extends Activity> targetActivity, boolean isFinish,
                              Bundle bundle) {
		if (activity == null) {
			Logger.e(Logger.Log_Utils,
					"参数传入错误-ActivityUtils.java--jumpTo(4)的第一个参数");
			return;
		}
		if (targetActivity == null) {
			Logger.e(Logger.Log_Utils,
					"参数传入错误-ActivityUtils.java--jumpTo(4)的第二个个参数");
			return;
		}

		if (bundle == null) {
			Logger.e(Logger.Log_Utils,
					"参数传入错误-ActivityUtils.java--jumpTo(4)的第三个个参数，或者使用正确方法");
			return;
		}
		Intent intent = new Intent(activity, targetActivity);
		intent.putExtras(bundle);
		activity.startActivity(intent);
		if (isFinish) {
			// true,那就是关闭
			activity.finish();
		}
	}

	public static void jumpToForResult(Activity activity,
                                       Class<? extends Activity> targetActivity, boolean isFinish,
                                       int requestCode) {
		if (activity == null) {
			Logger.e(Logger.Log_Utils,
					"参数传入错误-ActivityUtils.java--jumpToForResult(5)的第一个参数");
			return;
		}
		if (targetActivity == null) {
			Logger.e(Logger.Log_Utils,
					"参数传入错误-ActivityUtils.java--jumpToForResult(5)的第二个个参数");
			return;
		}

		Intent intent = new Intent(activity, targetActivity);
		activity.startActivityForResult(intent, requestCode);
		if (isFinish) {
			// true,那就是关闭
			activity.finish();
		}
	}

	public static void jumpToForResult(Activity activity,
                                       Class<? extends Activity> targetActivity, boolean isFinish,
                                       Bundle bundle, int requestCode ) {
		if (activity == null) {
			Logger.e(Logger.Log_Utils,
					"参数传入错误-ActivityUtils.java--jumpToForResult(4)的第一个参数");
			return;
		}
		if (targetActivity == null) {
			Logger.e(Logger.Log_Utils,
					"参数传入错误-ActivityUtils.java--jumpToForResult(4)的第二个个参数");
			return;
		}
		if (bundle == null) {
			Logger.e(Logger.Log_Utils,
					"参数传入错误-ActivityUtils.java--jumpToForResult(5)的第五个个个参数，或者使用正确方法");
			return;
		}
		Intent intent = new Intent(activity, targetActivity);
		intent.putExtras(bundle);
		activity.startActivityForResult(intent, requestCode);
		if (isFinish) {
			// true,那就是关闭
			activity.finish();
		}
	}
	public static void jumpToForResult(Fragment fragment,
                                       Class<? extends Activity> targetActivity, boolean isFinish,
                                       Bundle bundle, int requestCode ) {
		if (fragment == null) {
			Logger.e(Logger.Log_Utils,
					"参数传入错误-ActivityUtils.java--jumpToForResult(4)的第一个参数");
			return;
		}
		if (targetActivity == null) {
			Logger.e(Logger.Log_Utils,
					"参数传入错误-ActivityUtils.java--jumpToForResult(4)的第二个个参数");
			return;
		}
		if (bundle == null) {
			Logger.e(Logger.Log_Utils,
					"参数传入错误-ActivityUtils.java--jumpToForResult(5)的第五个个个参数，或者使用正确方法");
			return;
		}
		Activity activity = fragment.getActivity();
		if(activity == null){
			return ;
		}
		Intent intent = new Intent(activity, targetActivity);
		intent.putExtras(bundle);
		fragment.startActivityForResult(intent, requestCode);
		if (isFinish) {
			// true,那就是关闭
			activity.finish();
		}
	}


}
