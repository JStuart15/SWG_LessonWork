/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.messagetemplate.dao;

import com.sg.messagetemplate.model.MessageTemplate;
import java.util.List;

/**
 *
 * @author jstuart15
 */
public interface MessageTemplateDao {

    public List<MessageTemplate> getAllMessageTemplates();
}
