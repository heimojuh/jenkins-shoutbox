package hudson.plugins.shoutbox.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: heimojuh
 * Date: 27.11.2010
 * Time: 19:08:41
 */
public class HudsonShoutBox {


    private final CopyOnWriteArrayList<HudsonShoutMessage> listofshouts =
            new CopyOnWriteArrayList<HudsonShoutMessage>();

    public HudsonShoutBox() {

    }

    public synchronized void addShout(HudsonShoutMessage shout)
    {

            this.listofshouts.add(shout);
    }

    public List<HudsonShoutMessage> getShouts() {
        
        return this.listofshouts;
    }

    public HudsonShoutMessage getLatest() {

        if (this.getShouts().isEmpty())
            return null;

        //Collections.sort(this.listofshouts);                    //sorts the
        return this.listofshouts.get(this.listofshouts.size()-1);

    }

    /**
     * Lists are naturally sorted for our needs, since new stuff is always appended to the end. How very
     * weird thinking from me.
     * 
     * @param n - how many shouts we want
     * @return
     */
    public synchronized List<HudsonShoutMessage> getNLatestShoutsSorted(int n) {

        if (n >= this.listofshouts.size())
        {
                return  this.listofshouts;
        }
        if (n == 0)
            return new ArrayList<HudsonShoutMessage>();

            List<HudsonShoutMessage> smallist;

            smallist = this.listofshouts.subList(this.listofshouts.size()-n,this.listofshouts.size());

        return smallist;
    }

    
}
