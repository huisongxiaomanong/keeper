package com.qfedu.keep.common.miaodiyun.httpApiDemo;



import com.qfedu.keep.common.RandUtil;
import com.qfedu.keep.common.miaodiyun.httpApiDemo.common.Config;
import com.qfedu.keep.common.miaodiyun.httpApiDemo.common.HttpUtil;

import java.net.URLEncoder;

/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS
{
	private static String operation = "/industrySMS/sendSMS";
	private static String uuid = RandUtil.getRandNum();
	private static String accountSid = Config.ACCOUNT_SID;
	//private static String to = "17585120052";
	//private static String smsContent ="【千峰教育练习】您的验证码为{"+ uuid +"}，请于2分钟内正确输入，如非本人操作，请忽略此短信。";

	/**
	 * 验证码通知短信
	 */
	public static void execute(String to,String smsContent)
	{
		String tmpSmsContent = null;
	    try{
	      tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
	    }catch(Exception e){
	      
	    }
	    String url = Config.BASE_URL + operation;
	    String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + tmpSmsContent
	        + HttpUtil.createCommonParam();

	    // 提交请求
	    String result = HttpUtil.post(url, body);
	    System.out.println("result:" + System.lineSeparator() + result);
	}
}