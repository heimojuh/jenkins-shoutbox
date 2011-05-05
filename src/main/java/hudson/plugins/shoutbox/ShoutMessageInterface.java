package hudson.plugins.shoutbox;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: heimojuh
 * Date: 27.11.2010
 * Time: 14:26:58
 */
public interface ShoutMessageInterface extends Comparable<ShoutMessageInterface> {

    /**
     * Get the actual content of the shout
     * @return message as text
     */

    public String getMessageText();

    /**
     * Returns the username who shouted the messagage
      * @return username as text
     */
    public String getUser();

    /**
     * Returns the date object that holds the time when message was shouted
     * @return date when message was shouted
     */
    public Date getDate();

    


}
