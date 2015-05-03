package main.com.mantiso;

import main.com.pluralsight.Container;
import main.com.pluralsight.IoCException;

//import com.mantiso.Drivable;

public class Main {

    public static void main(String[] args) {
        try {
            Container container = new Container("config.json");
            IMeeting meeting = (IMeeting) container.resolve(IMeeting.class);
            meeting.getMeeting();
            for (String attendee : meeting.getAttendees()) {
                System.out.println(attendee);
            }
        } catch (IoCException e) {
            e.printStackTrace();
        }
    }
}

