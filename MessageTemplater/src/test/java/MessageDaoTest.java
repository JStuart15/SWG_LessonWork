/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.sg.messagetemplater.dao.MessageTemplateDao;
import com.sg.messagetemplater.dao.MessageTemplateDaoJsonFileImpl;
import com.sg.messagetemplater.model.MessageTemplate;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jstuart15
 */
public class MessageDaoTest {
    
    MessageTemplateDao dao = new MessageTemplateDaoJsonFileImpl();
    
    public MessageDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetAllMessageTemplates() {
        List<MessageTemplate> messageTemplateList = dao.getAllMessageTemplates();
        assertEquals(3, messageTemplateList.size());
    }
    
    @Test
    public void testGetMessageThatExists() {
        assertEquals("Your Room is Ready", dao.getMessageTemplateById(1).getName());
        assertEquals(3, dao.getMessageTemplateById(3).getId());
    }
    @Test
    public void testGetMessageThatDoesntExist() {
        assertNull(dao.getMessageTemplateById(99));
    }
}
