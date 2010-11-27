package hudson.plugins.objects;

import hudson.plugins.ShoutMessageInterface;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: heimojuh
 * Date: 27.11.2010
 * Time: 17:49:08
 */
public class HudsonShoutMessage implements ShoutMessageInterface {

    String MessageText;
    String User;
    Date date;



    HudsonShoutMessage(Date date, String user, String message){
        this.MessageText = message;
        this.User = user;
        this.date = date;

    }



    public String getMessageText() {
        return this.MessageText;
    }

    public String getUser() {
        return this.User;
    }

    public Date getDate() {
        return this.date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HudsonShoutMessage that = (HudsonShoutMessage) o;

        if (MessageText != null ? !MessageText.equals(that.MessageText) : that.MessageText != null) return false;
        if (User != null ? !User.equals(that.User) : that.User != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = MessageText != null ? MessageText.hashCode() : 0;
        result = 31 * result + (User != null ? User.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    public int compareTo(ShoutMessageInterface o) {
        final int EQUAL = 0;
        if (this == o)
            return EQUAL;

        return this.getDate().compareTo(o.getDate());

    }
}
