/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.messagetemplater.controller;

import com.sg.messagetemplater.dao.MessageTemplateDao;
import com.sg.messagetemplater.dao.MessageTemplateDaoJsonFileImpl;
import com.sg.messagetemplater.model.MessageTemplate;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jstuart15
 */
@RestController
public class MessageTemplateController {

    private final MessageTemplateDao messageTemplateDao = new MessageTemplateDaoJsonFileImpl();

    @RequestMapping(value = "/messagetemplates", method = RequestMethod.GET)
    public List<MessageTemplate> getAllMessageTemplates() {
        return messageTemplateDao.getAllMessageTemplates();
    }
}
