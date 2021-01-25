package com.huchx.email.controller;

import org.apache.logging.log4j.message.SimpleMessage;
import org.omg.CosNaming.NamingContextHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Author: Huchx
 * Date: 2021/1/25 13:24
 */
@RestController
public class EmailController {
    @Resource
    JavaMailSender mailSender;

    @RequestMapping("/send")
    public String send(String type) throws MessagingException {
        if (StringUtils.isEmpty(type)) type="0";
        if (type.equals("0")){
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("xxxxxxxx@163.com");
            mailMessage.setTo("xxxxxxxx@qq.com");
            mailMessage.setSubject("发送测试邮件");
            mailMessage.setText("此邮件由Java动态发送");
            mailSender.send(mailMessage);
            return  "Send Success";
        }else if (type.equals("1")){
            MimeMessage mailMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mailMessage,true);
            helper.setFrom("xxxxxxxx@163.com");
            helper.setTo("xxxxxxxx@qq.com");
            helper.setSubject("发送测试邮件");
            helper.setText("此邮件由Java动态发送,并带有附件");
            FileSystemResource fileSystemResource = new FileSystemResource(new File("E:\\custom_project\\springboot\\spring-boot-parent\\spring-boot-email\\src\\main\\resources\\img.jpg"));
            helper.addAttachment("img.jpg",fileSystemResource);
            mailSender.send(mailMessage);
            return  "Send Success";
        }else if (type.equals("2")){
            MimeMessage mailMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mailMessage,true);
            helper.setFrom("xxxxxxxx@163.com");
            helper.setTo("xxxxxxxx@qq.com");
            helper.setSubject("发送测试邮件");
            helper.setText("<html><body><img src=\"cid:img\" ></body></html>", true);
            FileSystemResource fileSystemResource = new FileSystemResource(new File("E:\\custom_project\\springboot\\spring-boot-parent\\spring-boot-email\\src\\main\\resources\\img.jpg"));
            helper.addInline("img",fileSystemResource);
            mailSender.send(mailMessage);
            return  "Send Success";
        }
        return "Send Error";
    }
}
