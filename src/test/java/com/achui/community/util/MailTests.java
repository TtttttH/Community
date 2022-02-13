package com.achui.community.util;

import com.achui.community.CommunityApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {

    private MailClient mailClient;

    private TemplateEngine templateEngine;

    @Autowired
    public void setMailClient(MailClient mailClient) {
        this.mailClient = mailClient;
    }

    @Autowired
    public void setTemplateEngine(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Test
    public void testTextMail() {
        mailClient.sendMail("th13282416529@163.com", "TestNowcoder", "Hello World");
    }

    @Test
    public void testHtmlMail() {
        Context context = new Context();
        context.setVariable("username", "sunday");

        String content = templateEngine.process("/mail/demo", context);
        System.out.println(content);
        mailClient.sendMail("th13282416529@163.com", "HTML", content);
    }
}
