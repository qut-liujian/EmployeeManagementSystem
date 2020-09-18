package neu.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {

	/**
	 * 从程序中发送的邮件，不管给谁，发件箱是固定
	 * 改变的只是收件人
	 * @param email
	 * @param code
	 * @return
	 */
	public static boolean send(String email,String code) {
		boolean flag=false;
		try {
			SimpleEmail simple=new SimpleEmail();
			//设置邮件的编码
			simple.setCharset("utf-8");
			//发件箱的服务器
			simple.setHostName("smtp.163.com");
			//其中的密码不是登录邮箱的密码，而是邮箱允许第三方机构发邮件的授权码
			//userName 是邮箱的前缀 @以前的内容
			simple.setAuthentication("x15106521031", "PJIKJQNZJJWDOLTA");
			//设置发件箱
			simple.setFrom("x15106521031@163.com", "东软教育集团");
			//设置收件箱,
			simple.addTo(email);
			//设置邮箱的标题
			simple.setSubject("密码找回验证码");
			//设置邮件正文
			simple.setMsg("验证码【"+code+"】");
			//发送邮件
			simple.send();
			flag=true;
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}

