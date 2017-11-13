/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sg.messagetemplater.dao.GuestDao;
import com.sg.messagetemplater.dao.GuestDaoJsonFileImpl;
import com.sg.messagetemplater.model.Guest;
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
public class GuestDaoTest {

    GuestDao dao = new GuestDaoJsonFileImpl();

    public GuestDaoTest() {
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
    public void testGetAllGuests() {
        List<Guest> guestList = dao.getAllGuests();
        assertEquals(6, guestList.size());
    }

    @Test
    public void testGetGuestThatExists() {
        assertEquals(2, dao.getGuestById(2).getId());
        assertEquals("Hewitt", dao.getGuestById(6).getFirstName());
        assertEquals("529", dao.getGuestById(1).getReservation().getRoomNumber());
    }

    @Test
    public void testGetGuestThatDoesntExist() {
        assertNull(dao.getGuestById(20));
    }
}
