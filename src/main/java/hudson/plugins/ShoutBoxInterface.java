package hudson.plugins;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: heimojuh
 * Date: 27.11.2010
 * Time: 14:55:04
 */
public interface ShoutBoxInterface {

    /**
     * Gives list of messages
     *
     * @return List of shoutmessages
     */
    List<ShoutMessageInterface> getShouts();

    /**
     * Get's messages sorted
     * @return
     */
    List<ShoutMessageInterface> getShoutsSorted();

    /**
     *  Returns latest shoutMessage
      * @return Latest (most recent) ShoutMessageInterface
     */
    ShoutMessageInterface getLatest();

    /**
     * Get's N amount of latest shouts
     * @param n amount of shouts
     * @return List of shouts
     */
    List<ShoutMessageInterface> getNLatestShouts(int n);


    /**
     * Guess what this does?
     * @param n
     * @return
     */
    List<ShoutMessageInterface> getNLatestShoutsSorted(int n);


}
