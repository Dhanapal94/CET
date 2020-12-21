package com.cet.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.cet.intit.Base;

public class Mail {

	public static void getMail() {
		String timeStamp = new SimpleDateFormat("M/d/yyyy hh:mm:ss").format(new Date());
		StringBuilder mailBody = new StringBuilder();
		mailBody.append("<html>\r\n" + 
				"<head>\r\n" + 
				"<style>\r\n" + 
				"table, th, td {\r\n" + 
				"  border: 1px solid black;\r\n" + 
				" border-collapse: collapse;\r\n" + 
				"}\r\n" + 
				"th, td {\r\n" + 
				"  padding: 5px;\r\n" + 
				"}\r\n" + 
				"th {\r\n" + 
				"  text-align: left;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<p>Hi  Team,<p>\r\n" + 
				"<p> This is to notify that automation process for CET project has been<font color=52D118><strong> Completed.</strong></font></p>\r\n" + 
				"<p>Please find the attached Report.</p>\r\n" + 
				"<table style=\"width:100%\">\r\n" + 
				"  <tr>\r\n" + 
				"    <th>Team/Module</th>\r\n" + 
				"    <th>Total Testcase</th> \r\n" + 
				"    <th>Testcase Passed</th>\r\n" + 
				"    <th>Testcase Failed</th>\r\n" + 
				"    <th>Testcase Skipped</th>\r\n" + 
				"  </tr>\r\n" + 
				"  <tr>\r\n" + 
				"    <td>"+Base.team+"</td>\r\n" + 
				"    <td>"+Base.totoalTestCount+"</td>\r\n" + 
				"    <td>"+Base.totoalPassCount+"</td>\r\n" + 
				" <td>"+Base.totoalFailCount+"</td>\r\n" + 
				" <td>"+Base.totoalSkipCount+"</td>\r\n" + 
				"  </tr>\r\n" + 
				"</table>\r\n" + 
				"<br>\r\n" + 
				"<p>Regards,</p>\r\n" + 
				"<p>Automation Team</p>\r\n" + 
				"</body>\r\n" + 
				"</html>");

		final String username = "Dummy";
		final String password = "Dummy";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "mailo2.uhc.com");

		@SuppressWarnings("unused")
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		
		  try {
		  
		  Message message = new MimeMessage(session); message.setFrom(new
		  InternetAddress("dhanapal.a@optum.com"));
		  
		  message.setRecipients(Message.RecipientType.TO,
		  InternetAddress.parse(Readconfig.getMailToRecipients()));
		  
		  message.setSubject("CET Automation Report ("+Base.team+") -"+timeStamp);
		  
		  BodyPart messageBodyPart1 = new MimeBodyPart();
		  messageBodyPart1.setText("<html><font color = red>Red</font></html>");
		  messageBodyPart1.setContent(mailBody.toString(), "text/html");
		  
		  MimeBodyPart messageBodyPart2 = new MimeBodyPart(); 
		  String filename ="./ExtentReports\\"+Base.reportname;// Mention the file which you want to send
		  DataSource source = new FileDataSource(filename);
		  messageBodyPart2.setDataHandler(new DataHandler(source));
		  messageBodyPart2.setFileName(filename);
		  
		  Multipart multipart = new MimeMultipart();
		  multipart.addBodyPart(messageBodyPart2);
		  multipart.addBodyPart(messageBodyPart1); message.setContent(multipart);
		  
		 Transport.send(message); 
		 System.out.println("Mail Sent Successfully");
		  
		  } catch (MessagingException e) { throw new RuntimeException(e); }
		 
	}

}