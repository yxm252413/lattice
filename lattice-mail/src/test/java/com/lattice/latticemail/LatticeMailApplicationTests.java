package com.lattice.latticemail;

import com.lattice.latticemail.service.impl.MailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LatticeMailApplicationTests {

	@Autowired
	private MailServiceImpl mailService;

	@Autowired
	private TemplateEngine templateEngine;



	@Test
	public void contextLoads() {
		mailService.sendSimpleMail("961099916@qq.com", "代码发个邮件", "测试");
	}

	@Test
	public void sendTemplatesMail() throws MessagingException, UnsupportedEncodingException {
		/**
		 *
		 * 功能描述: 测试根据thymeleaf模版发送HTML邮件
		 *
		 * @param: []
		 * @return: void
		 * @auther: ZhangJiahao
		 * @date: 2018/10/2 19:56
		 */
		Context context = new Context();
		context.setVariable("id","100");
		String emailContent = templateEngine.process("register",context);
		mailService.sendHtmlMail("zhangjiahao831@163.com", "这是一个模版邮件", emailContent);
	}


}
