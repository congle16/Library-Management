package com.team4.lib.config;

import java.io.IOException;
import java.util.Properties;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineFactory;

@Configuration
public class BeanConfig {

  @Autowired
  private Environment env;

  @Bean(name = "messageSource")
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource =
        new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("classpath:/i18n/messages");
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }

  @Bean
  public JavaMailSender getJavaMailSender() {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost(env.getProperty("mail.host"));
    mailSender.setPort(Integer.parseInt(env.getProperty("mail.port")));

    mailSender.setUsername(env.getProperty("mail.username"));
    mailSender.setPassword(env.getProperty("mail.password"));

    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.debug", "true");

    return mailSender;
  }

  @SuppressWarnings("deprecation")
  @Bean
  public VelocityEngine getVelocityEngine() throws VelocityException, IOException {
    VelocityEngineFactory velocityEngineFactory = new VelocityEngineFactory();
    Properties props = new Properties();
    props.put("resource.loader", "class");
    props.put("class.resource.loader.class",
        "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

    velocityEngineFactory.setVelocityProperties(props);
    return velocityEngineFactory.createVelocityEngine();
  }

}
