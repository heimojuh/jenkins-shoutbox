package hudson.plugins.shoutbox.objects;

import hudson.plugins.shoutbox.ShoutBoxInterface;
import hudson.plugins.shoutbox.ShoutMessageInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: heimojuh
 * Date: 27.11.2010
 * Time: 19:08:41
 */
public class HudsonShoutBox implements ShoutBoxInterface {

    private final List<ShoutMessageInterface> listofshouts = Collections.synchronizedList(new ArrayList<ShoutMessageInterface>());

    public HudsonShoutBox() {

    }

    public synchronized void addShout(ShoutMessageInterface shout)
    {

        synchronized(this.listofshouts)
        {
            this.listofshouts.add(shout);
        }
        
    }

    public List<ShoutMessageInterface> getShouts() {
        return this.listofshouts;
    }

    public List<ShoutMessageInterface> getShoutsSorted() {
        return null;  
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

    public synchronized List<ShoutMessageInterface> getNLatestShoutsSorted(int n) {

        if (n >= this.listofshouts.size())
        {
                synchronized(this.listofshouts)
                {
                    Collections.sort(this.listofshouts);
                }
                return  this.listofshouts;
        }
        if (n == 0)
            return new ArrayList<ShoutMessageInterface>();

            List<ShoutMessageInterface> smallist;


            smallist = this.listofshouts.subList(this.listofshouts.size()-n,this.listofshouts.size());
            synchronized(this.listofshouts)
            {
                Collections.sort(smallist);
            }
       
        return smallist;
    }

    
}
