/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.messagetemplater.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sg.messagetemplater.model.MessageTemplate;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public class MessageTemplateDaoJsonFileImpl implements MessageTemplateDao {

    List<MessageTemplate> messageTemplateList = new ArrayList<>();

    @Override
    public List<MessageTemplate> getAllMessageTemplates() {
        loadMessageTemplates();
        return messageTemplateList;
    }

    private void loadMessageTemplates() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File fileName = new File("MessageTemplates.json");
            messageTemplateList = mapper.readValue(fileName,
                    new TypeReference<List<MessageTemplate>>() {
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public MessageTemplate getMessageTemplateById(long id) {
        loadMessageTemplates();
        int index;
        for (MessageTemplate message : messageTemplateList) {
            if (message.getId() == id) {
                return message;
            } else {
                return null;
            }
        }
        return null;
    }
}
