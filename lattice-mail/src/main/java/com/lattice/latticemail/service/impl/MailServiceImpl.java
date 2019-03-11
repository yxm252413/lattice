package com.lattice.latticemail.service.impl;

import com.lattice.latticemail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-22 23:05
 **/
@Service
public class MailServiceImpl implements MailService {
    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;


    public void sendSimpleMail(String to, String subject, String content) {
        /**
         *
         * 功能描述: 发送简单的邮件
         * 		to : 目标邮箱
         * 		subject:标题
         * 		content：内容
         * 		from：发送人邮箱
         *
         * @param: [to, subject, content]
         * @return: void
         * @auther: ZhangJiahao
         * @date: 2018/10/2 19:48
         */
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setText(content);
        simpleMailMessage.setFrom(from);
        mailSender.send(simpleMailMessage);
    }


    public void sendHtmlMail(String to, String subject, String content) throws MessagingException, UnsupportedEncodingException {
        /**
         *
         * 功能描述: 发送HTML邮件
         * 		to : 目标邮箱
         * 		subject:标题
         * 		content：内容
         * 		from：发送人邮箱
         * @param: [to, subject, content]
         * @return: void
         * @auther: ZhangJiahao
         * @date: 2018/10/2 19:49
         */
        MimeMessage mimeMailMessage = mailSender.createMimeMessage();
        mimeMailMessage.setFrom(new InternetAddress("zhangjiahao831@163.com", "张家豪"));
        MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setFrom(from);
        // 设置内容是HTML
        helper.setText(content, true);
        mailSender.send(mimeMailMessage);

    }


    public void sendAttachmentsMail(String to, String subject, String content, String filePath) throws MessagingException {
        /**
         *
         * 功能描述: 发送带有附件的邮件
         *		to：收件人的邮箱
         *		subject：主题
         *		content：内容
         *		filePath：附件的文件地址 目前网络路径失败
         * @param: [to, subject, content, filePath]
         * @return: void
         * @auther: ZhangJiahao
         * @date: 2018/10/2 19:51
         */
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setText(content, true);
        helper.setSubject(subject);
        FileSystemResource fileSystemResource = new FileSystemResource(new File(filePath));
        String fileName = fileSystemResource.getFilename();
        helper.addAttachment(fileName, fileSystemResource);
        mailSender.send(mimeMessage);

    }


    public void sendInlinResourceMail(String to, String subject, String content, String rscPath, String rsId) throws MessagingException {
        /**
         *
         * 功能描述: 发送图片邮件
         * 		to：收件人的邮箱
         * 		subject：主题
         * 		content：内容（包含图片的内容即：HTML格式，可以用thymeleaf模版）
         * 		rscPath: 图片的路径
         * 		rsId：图片的编号，用于生成个content
         *
         * @param: [to, subject, content, rscPath, rsId]
         * @return: void
         * @auther: ZhangJiahao
         * @date: 2018/10/2 19:52
         */
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(to);
        helper.setFrom(from);
        helper.setText(content, true);
        helper.setSubject(subject);
        FileSystemResource fileSystemResource = new FileSystemResource(new File(rscPath));
        helper.addInline(rsId, fileSystemResource);
        mailSender.send(mimeMessage);

    }

    public void sendTemplateMail(String to, String action, String date) throws UnsupportedEncodingException,
            MessagingException {
        Context context = new Context();
        String emailContent;
        String subject;
        if ("register" == action) {
            context.setVariable("id", date);
            emailContent = templateEngine.process("register", context);
            subject = "注册";

        } else if ("code" == action) {
            context.setVariable("code", date);
            emailContent = templateEngine.process("code", context);
            subject = "激活码";
        } else {
            throw new RuntimeException();
        }
        this.sendHtmlMail(to, subject, emailContent);

    }
}
