package hudson.plugins.shoutbox;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: heimojuh
 * Date: 27.11.2010
 * Time: 14:55:04
 */
public interface ShoutBox {

    /**
     * Gives list of messages
     *
     * @return List of shoutmessages
     */
    List<ShoutMessage> getShouts();

    /**
     * Get's messages sorted
     * @return
     */
    List<ShoutMessage> getShoutsSorted();

    /**
     *  Returns latest shoutMessage
      * @return Latest (most recent) ShoutMessage
     */
    ShoutMessage getLatest();

    /**
     * Get's N amount of latest shouts
     * @param n amount of shouts
     * @return List of shouts
     */
    List<ShoutMessage> getNLatestShouts(int n);


    /**
     * Guess what this does?
     * @param n
     * @return
     */
    List<ShoutMessage> getNLatestShoutsSorted(int n);


}
