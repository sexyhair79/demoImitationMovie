package com.sexyhair.demoimitationmovie.common.utils;

import android.graphics.drawable.Drawable;
import android.support.v7.content.res.AppCompatResources;
import android.text.TextUtils;

import com.sexyhair.demoimitationmovie.common.context.AppContext;

import java.util.Locale;

/**
 * 跟资源相关的
 * @author Administrator
 *
 *
 */
public class ResFileUtil {
	/**
	 * 获取String
	 * @param resId
	 * @return
	 * TODO：把BaseActivity 中的这个方法改了
	 */
	public static String getStringByResId(int resId){
		String str = AppContext.appContext.getResources().getString(resId);
		if(TextUtils.isEmpty(str)){
			str = "";
			Logger.w(Logger.Log_Utils, "BaseActivity.java-getStringByResId参数不对");
		}
		return str;
	}
	
	/**
	 * 获取String 带有占位符的
	 * 没有 参数是 int int 的，因为就不需要占位符了
	 * @param resId 带有占位符的
	 * @param content 
	 * @return
	 */
	public static String getStringByResId(int resId, String content){
		if(TextUtils.isEmpty(content)){
			content = "";
			Logger.w(Logger.Log_Utils, "BaseActivity.java-getStringByResId参数不对");
		}
		
		String str = String.format(AppContext.appContext.getResources().getString(resId), content);
		if(TextUtils.isEmpty(str)){
			str = "";
			Logger.w(Logger.Log_Utils, "BaseActivity.java-getStringByResId参数不对");
		}
		return str;
	}
	/**
	 * 获取String 带有占位符的
	 * 没有 参数是 int int 的，因为就不需要占位符了
	 * @param resId 带有占位符的
	 * @param content 
	 * @return
	 */
	public static String getStringByResId(int resId, String content, String content2){
		if(TextUtils.isEmpty(content)){
			content = "";
			Logger.w(Logger.Log_Utils, "BaseActivity.java-getStringByResId参数不对");
		}
		
		String str = String.format(AppContext.appContext.getResources().getString(resId), content,content2);
		if(TextUtils.isEmpty(str)){
			str = "";
			Logger.w(Logger.Log_Utils, "BaseActivity.java-getStringByResId参数不对");
		}
		return str;
	}
	
//	/**
//	 * 获取String 带有占位符的
//	 * 没有 参数是 int int 的，因为就不需要占位符了
//	 * @param resId 带有占位符的
//	 * @param content
//	 * @return
//	 */
//	public static String getStringByResId(int resId, String...content ){
//		if(content == null){
//			Logger.w(Logger.Log_Utils, "BaseActivity.java-getStringByResId参数不对");
//			return "";
//		}
//		String str = String.format(AppContext.appContext.getResources().getString(resId), content);
//		if(TextUtils.isEmpty(str)){
//			str = "";
//			Logger.w(Logger.Log_Utils, "BaseActivity.java-getStringByResId参数不对");
//		}
//		return str;
//	}
	
	/**
	 * 获取String
	 * @param resId
	 * @return
	 * TODO：把BaseActivity 中的这个方法改了
	 */
	public static int getColorByResId(int resId){
		int str = -1;
		try {
			str = AppContext.appContext.getResources().getColor(resId);
		} catch (Exception e) {
			Logger.w(Logger.Log_Utils, "BaseActivity.java-getStringByResId参数不对");
		}
		return str;
	}
	
	/**
	 * 获取String
	 * 
	 * @param resId
	 * @return TODO：把BaseActivity 中的这个方法改了
	 */
	public static int getDimenByResId(int resId) {
		int str = -1;
		try {
			str = AppContext.appContext.getResources().getDimensionPixelSize(resId);
		} catch (Exception e) {
			Logger.w(Logger.Log_Utils, "BaseActivity.java-getStringByResId参数不对");
		}
		return str;
	}
	/**
	 * 保留两位小数
	 * @param number
	 * @return
	 */
	public static String switchTwoDecimal(Double number) {
		return String.format(Locale.CHINA, "%1$3.2f", number);
	}
	
	/**
	 * 保留两位小数
	 * @param number
	 * @return
	 */
	public static String switchTwoDecimal(String number) {
		return String.format(Locale.CHINA, "%1$3.2f", Double.parseDouble(number));
	}
	
	/**
	 * 
	 * @param resId
	 * @return
	 */
	public static Drawable getDrawable(int resId) {
		Drawable drawable = null;
		try {
//			drawable = AppContext.appContext.getResources().getDrawable(resId);
			drawable = AppCompatResources.getDrawable(AppContext.appContext,resId);
		} catch (Exception e) {
			Logger.i(Logger.Log_View,
					"LoadSelfRefListView.java-->getDrawable(int resid)方法参数不正确");
		}
		return drawable;
	}
}
