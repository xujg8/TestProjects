package com.tcl.mie.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendTextMailByTCL {

	public static void main(String[] args) throws Exception {
		Properties prop = new Properties();
		prop.setProperty("mail.host", "mailsz.tct.tcl.com");
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.setProperty("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(prop);
		session.setDebug(true);
		Transport ts = session.getTransport();
		ts.connect("mailsz.tct.tcl.com", "jianguoxu", "xujg8@1234");
		Message message = createSimpleMail(session);
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	}

	private static Message createSimpleMail(Session session) throws Exception {
		//创建邮件对象
		MimeMessage message = new MimeMessage(session);
		//指明邮件的发件人
		message.setFrom(new InternetAddress("jianguoxu@tcl.com"));
		//指明邮件的收件人
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("jianguoxu@tcl.com"));
		//邮件的标题
		message.setSubject("只包含文本的简单邮件");
		 //邮件的文本内容
		message.setContent("hello", "text/html;charset=UTF-8");
		//返回创建好的邮件对象
		return message;
	}

}
