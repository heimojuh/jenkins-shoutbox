package hudson.plugins.shoutbox;

import hudson.model.Action;
import hudson.model.ProminentProjectAction;
import hudson.plugins.shoutbox.objects.HudsonShoutBox;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: heimojuh
 * Date: 28.11.2010
 * Time: 2:06:01
 */
public class ShoutBoxAction implements ProminentProjectAction {

    HudsonShoutBox shoutbox;

    @DataBoundConstructor
    public ShoutBoxAction() {
        this.shoutbox = new HudsonShoutBox();
        System.out.println("ShoutBox added");
    }

    public String getIconFileName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String getDisplayName() {
        return "ShoutBox";  //To change body of implemented methods use File | Settings | File Templates.
    }

    public String getUrlName() {
        return "shoutbox";  //To change body of implemented methods use File | Settings | File Templates.
    }
}
