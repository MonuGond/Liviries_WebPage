package eMail;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtility {

	/*public static void sendEmailWithAttachment(String host, String port, final String userName, final String password, String receipient,
			String subject, String content, List<File> uploadedFiles) {*/
		// TODO Auto-generated method stub
		
		//Send a email from SMTP Host with attach file
				public static void sendEmailWithAttachment(String host, String port, final String userName,
															final String password, String toAddress, String subject,
															String message, List<File>attachedFiles) throws AddressException, MessagingException {
					//set SMTP Server Properties
					Properties prop = new Properties();
					prop.put("mail.smtp.host", host);
					prop.put("mail.smtp.port", port);
					prop.put("mail.smtp.auth", true);
					prop.put("mail.smtp.starttls.enable", "true");
					prop.put("mail.user", userName);
					prop.put("mail.password", password);
					
					//create a new session with an authenticator
					Authenticator auth = new Authenticator() {
						public PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(userName, password);
						}
					};
					Session session = Session.getInstance(prop, auth);
					
					//create a new e-mail message
					Message msg=new MimeMessage(session);
					msg.setFrom(new InternetAddress(userName));
					InternetAddress[] toAddresses= {new InternetAddress(toAddress)};
					msg.setRecipients(Message.RecipientType.TO, toAddresses);
					msg.setSubject(subject);
					msg.setSentDate(new Date());
					
					//create message part
					MimeBodyPart messageBodyPart = new MimeBodyPart();
					messageBodyPart.setContent(message, "text/html");
					
					// create multi-part
					Multipart multipart = new MimeMultipart();
					multipart.addBodyPart(messageBodyPart);
					
					//adds attachments
					//String fileName = new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());
					if(attachedFiles !=null && attachedFiles.size()>0) {
						for(File afile:attachedFiles) {
							MimeBodyPart attachedPart = new MimeBodyPart();
							try {
								attachedPart.attachFile(afile);
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
							multipart.addBodyPart(attachedPart);
							multipart.addBodyPart(attachedPart);
							
						}
					}
					//sets the multpart as email content
					msg.setContent(multipart);
					//send the email
					Transport.send(msg);
		
	}

}
