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
		//�����ʼ�����
		MimeMessage message = new MimeMessage(session);
		//ָ���ʼ��ķ�����
		message.setFrom(new InternetAddress("jianguoxu@tcl.com"));
		//ָ���ʼ����ռ���
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("jianguoxu@tcl.com"));
		//�ʼ��ı���
		message.setSubject("ֻ�����ı��ļ��ʼ�");
		 //�ʼ����ı�����
		message.setContent("hello", "text/html;charset=UTF-8");
		//���ش����õ��ʼ�����
		return message;
	}

}
