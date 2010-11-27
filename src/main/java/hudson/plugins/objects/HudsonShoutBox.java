package hudson.plugins.objects;

import hudson.plugins.ShoutBoxInterface;
import hudson.plugins.ShoutMessageInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: heimojuh
 * Date: 27.11.2010
 * Time: 19:08:41
 */
public class HudsonShoutBox implements ShoutBoxInterface {

    private ArrayList<ShoutMessageInterface> listofshouts;

    public HudsonShoutBox() {
        this.listofshouts = new ArrayList<ShoutMessageInterface>();

    }

    public void addShout(ShoutMessageInterface shout)
    {
        this.listofshouts.add(shout);
    }

    public List<ShoutMessageInterface> getShouts() {
        return this.listofshouts;
    }

    public List<ShoutMessageInterface> getShoutsSorted() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * ShoutMessageInterface forces items to be comparable, so we can sort without problems
     * @return
     */
    public ShoutMessageInterface getLatest() {

        if (this.getShouts().isEmpty())
            return null;

        Collections.sort(this.listofshouts);                    //sorts the
        return this.listofshouts.get(this.listofshouts.size()-1);

    }

    public List<ShoutMessageInterface> getNLatestShouts(int n) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<ShoutMessageInterface> getNLatestShoutsSorted(int n) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
