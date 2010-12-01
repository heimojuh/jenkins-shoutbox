package hudson.plugins.shoutbox;

import hudson.model.Hudson;
import hudson.model.ProminentProjectAction;
import hudson.plugins.shoutbox.objects.HudsonShoutMessage;
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

    ShoutBoxInterface shoutbox;
    SimpleDateFormat dateformat = new SimpleDateFormat("dd.MM HH:mm:ss");
    
    private int numberofshoutsshown = 15;


    public ShoutBoxAction(ShoutBoxInterface box) {
        this.shoutbox = box;
        System.out.println("ShoutBox added");
    }

    private void addShout(String username, String shout)
    {
        this.shoutbox.addShout(new HudsonShoutMessage(new Date(), username, shout));
    }

    public void doPrintShouts(org.kohsuke.stapler.StaplerRequest req, org.kohsuke.stapler.StaplerResponse rsp) throws IOException
    {

       StringBuffer sb = new StringBuffer();
       sb.append("<table border=\"1\">");
      
           for (ShoutMessageInterface message : this.shoutbox.getNLatestShoutsSorted(numberofshoutsshown))
           {
                sb.append("<tr><td id=\"time\">").append(this.dateformat.format(message.getDate())).append("</td><td id=\"user\">").append(message.getUser()).append("</td><td id=\"shout\">").append(message.getMessageText()).append("</td></tr>\n");
           }

       
       sb.append("</table>");
       rsp.getWriter().print(sb.toString());
       rsp.getWriter().flush();
       
    }

     public  void doShout(org.kohsuke.stapler.StaplerRequest req, org.kohsuke.stapler.StaplerResponse rsp)
    {
        String shoutmessage = req.getParameter("shoutmessage");
        String shoutuser = req.getParameter("username");
        if (shoutmessage == null || shoutmessage.isEmpty() || shoutuser == null || shoutuser.isEmpty())
            return;
        this.addShout(shoutuser,shoutmessage);
    }

    public ShoutBoxInterface getShoutbox()
    {
        return this.shoutbox;
    }

    public List<ShoutMessageInterface> getShouts()
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
