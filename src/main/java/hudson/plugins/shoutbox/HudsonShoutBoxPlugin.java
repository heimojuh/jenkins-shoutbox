package hudson.plugins.shoutbox;

import hudson.Extension;
import hudson.model.*;
import hudson.tasks.*;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: heimojuh
 * Date: 28.11.2010
 * Time: 2:27:48
 */

public class HudsonShoutBoxPlugin extends JobProperty<AbstractProject<?,?>> {

   int numberOfShoutsShown;

   
   public HudsonShoutBoxPlugin()
   {

   }

    @Override
    public Collection<? extends Action> getJobActions(AbstractProject<?, ?> job) {
        ArrayList<Action> c = new ArrayList<Action>();
        c.add(new ShoutBoxAction());
        return c;    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Extension
   public static final DescriptorImpl DESCRIPTOR = new DescriptorImpl();


    public static final class DescriptorImpl extends JobPropertyDescriptor {
        // no longer in use but kept for backward compatibility
        private transient String tracWebsite;

        public DescriptorImpl() {
            super(HudsonShoutBoxPlugin.class);
            load();
        }

        @Override
        public JobProperty<?> newInstance(StaplerRequest req, JSONObject formData) throws FormException {
            if (formData.isNullObject()) {
	                return null;
	        }
            JSONObject parameterized = formData.getJSONObject("shoutbox");

	        if (parameterized.isNullObject()) {
	                return null;
	        }
            return new HudsonShoutBoxPlugin();    //To change body of overridden methods use File | Settings | File Templates.
        }

        @Override
        public boolean isApplicable(Class<? extends Job> jobType) {
            return AbstractProject.class.isAssignableFrom(jobType);
        }

        public String getDisplayName() {
            return "ShoutBox";
        }




    }


    public BuildStepMonitor getRequiredMonitorService() {
        return BuildStepMonitor.NONE;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
