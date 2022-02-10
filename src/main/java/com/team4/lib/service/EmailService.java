package com.team4.lib.service;

import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.team4.lib.dao.EmailDao;
import com.team4.lib.model.MailDto;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

@Service
public class EmailService implements EmailDao {

  @Autowired
  private JavaMailSender mailSender;

  @Autowired
  VelocityEngine velocityEngine;

  @Autowired
  private Environment env;

  @Override
  public void sendEmail(MailDto mail) {
    MimeMessage mimeMessage = mailSender.createMimeMessage();
    try {

      MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

      mimeMessageHelper.setSubject(mail.getMailSubject());
      mimeMessageHelper.setFrom(mail.getMailFrom());
      mimeMessageHelper.setTo(mail.getMailTo());
      mail.setMailContent(geContentFromTemplate(mail.getModel()));
      mimeMessageHelper.setText(mail.getMailContent(), true);

      mailSender.send(mimeMessageHelper.getMimeMessage());
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }

  public String geContentFromTemplate(Map<String, Object> model) {
    StringBuffer content = new StringBuffer();
    try {
      content.append(VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
          "/templates/email.vm", model));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return content.toString();
  }
}
