import com.google.common.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class EventCatcher {
        List<Object> caughtEvents = new ArrayList<>();

        @Subscribe
        public void catchEvent(Object event) {
            caughtEvents.add(event);
        }
    }
