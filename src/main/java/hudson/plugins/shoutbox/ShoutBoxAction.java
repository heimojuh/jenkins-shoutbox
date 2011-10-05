package hudson.plugins.shoutbox;

import com.google.gson.Gson;
import hudson.model.Hudson;
import hudson.model.ProminentProjectAction;
import hudson.plugins.shoutbox.objects.HudsonShoutBox;
import hudson.plugins.shoutbox.objects.HudsonShoutMessage;
import org.jsoup.Jsoup;
import org.kohsuke.stapler.HttpResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: heimojuh
 * Date: 28.11.2010
 * Time: 2:06:01
 */
public class ShoutBoxAction implements ProminentProjectAction {

    HudsonShoutBox shoutbox;
    SimpleDateFormat dateformat = new SimpleDateFormat("dd.MM HH:mm:ss");
    
    private int numberofshoutsshown = 15;


    public ShoutBoxAction(HudsonShoutBox box) {
        this.shoutbox = box;
        System.out.println("ShoutBox added");
    }

    private void addShout(String username, String shout)
    {
        this.shoutbox.addShout(new HudsonShoutMessage(new Date(), username, shout));
    }

     public  void doShout(org.kohsuke.stapler.StaplerRequest req, org.kohsuke.stapler.StaplerResponse rsp) throws IOException
    {
       String shoutmessage = req.getParameter("shoutmessage");
       String shoutuser = req.getParameter("username");
       if (shoutmessage == null || shoutmessage.isEmpty() || shoutuser == null || shoutuser.isEmpty())
       {

       }
       else
       {
           //TODO: Handle special commands /t and /c
           this.addShout(shoutuser, Jsoup.parse(shoutmessage).text());
       }
       Gson g = new Gson();
       rsp.getWriter().print(g.toJson((HudsonShoutBox) shoutbox));
       rsp.getWriter().flush();
    }

    public HudsonShoutBox getShoutbox()
    {
        return this.shoutbox;
    }

    public List<HudsonShoutMessage> getShouts()
    {
        return this.shoutbox.getNLatestShoutsSorted(numberofshoutsshown);
    }


    public String getIconFileName() {

        
        return null;
    }

    public String getDisplayName() {
        return "ShoutBox";
    }

    public String getUrlName() {
        return "shoutbox";
    }
}
