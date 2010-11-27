package hudson.plugins.objects;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: heimojuh
 * Date: 27.11.2010
 * Time: 19:12:00
 */
public class HudsonShoutBoxTest extends TestCase {

    ArrayList<HudsonShoutMessage> listofmessages;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");

    @Before
    public void setUp() throws Exception
    {

        listofmessages = new ArrayList<HudsonShoutMessage>();

       
        Date date1 = formatter.parse("2010-11-10-12.00.00");
        Date date2 = formatter.parse("2010-11-10-13.00.00");
        Date date3 = formatter.parse("2010-11-9-14.00.00");
        Date date4 = formatter.parse("2010-12-11-13.00.00");
        Date date5 = formatter.parse("2010-11-12-13.00.00");
        Date date6 = formatter.parse("2010-11-14-13.00.00");

        HudsonShoutMessage m1 = new HudsonShoutMessage(date1,"user1","message1");
        HudsonShoutMessage m2 = new HudsonShoutMessage(date2,"user2","message3");
        HudsonShoutMessage m3 = new HudsonShoutMessage(date3,"user3","message3");
        HudsonShoutMessage m4 = new HudsonShoutMessage(date4,"user4","message4");
        HudsonShoutMessage m5 = new HudsonShoutMessage(date5,"user5","message5");
        HudsonShoutMessage m6 = new HudsonShoutMessage(date6,"user6","message6");

        listofmessages.add(m1);
        listofmessages.add(m2);
        listofmessages.add(m3);
        listofmessages.add(m4);
        listofmessages.add(m5);
        listofmessages.add(m6);
    }

    @Test
    public void testGetShouts() throws Exception {

        HudsonShoutBox box = new HudsonShoutBox();
        for (HudsonShoutMessage m : this.listofmessages)
        {
            box.addShout(m);
        }

        for (HudsonShoutMessage m : this.listofmessages)
        {
            assertTrue(box.getShouts().contains(m));
        }
    }

    @Test
    public void testGetShoutsSorted() throws Exception {
    }

    @Test
    public void testGetLatest() throws Exception {

        HudsonShoutBox box = new HudsonShoutBox();
        for (HudsonShoutMessage m : this.listofmessages)
        {
            box.addShout(m);
        }

        assertEquals("2010-12-11-13.00.00", this.formatter.format(box.getLatest().getDate()));

        


    }

    @Test
    public void testGetNLatestShouts() throws Exception {
        throw new Exception();
    }

    @Test
    public void testGetNLatestShoutsSorted() throws Exception {
        throw new Exception();
    }


}
