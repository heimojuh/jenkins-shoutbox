package hudson.plugins.objects;

import junit.framework.TestCase;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: heimojuh
 * Date: 27.11.2010
 * Time: 17:55:42
 */
public class HudsonShoutMessageTest extends TestCase {
    @Test
    public void testGetMessageText() throws Exception {

        HudsonShoutMessage message = new HudsonShoutMessage(new Date(), "user","message");
        assertEquals("message",message.getMessageText());
    }

    @Test
    public void testGetUser() throws Exception {
        HudsonShoutMessage message = new HudsonShoutMessage(new Date(), "user","message");
        assertEquals("user",message.getUser());

    }

    @Test
    public void testGetDate() throws Exception {
        Date now = new Date();
        HudsonShoutMessage message = new HudsonShoutMessage(now, "user","message");
        assertEquals(now,message.getDate());
    }

    @Test
    public void testCompareTo() throws Exception {
        HudsonShoutMessage message1 = new HudsonShoutMessage(new Date(), "user","message");
        HudsonShoutMessage message2 = new HudsonShoutMessage(new Date(), "user","message");

        assertEquals(0,message1.compareTo(message2));
        assertEquals(0,message2.compareTo(message1));

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
        Date date1 = formatter.parse("2010-11-10-12.00.00");
        Date date2 = formatter.parse("2010-11-10-13.00.00");
        HudsonShoutMessage message3 = new HudsonShoutMessage(date1, "user","message");
        HudsonShoutMessage message4 = new HudsonShoutMessage(date2, "user","message");

        assertEquals(-1,message3.compareTo(message4));
        assertEquals(1,message4.compareTo(message3));


    }
}
