package cloud.folium.spring;

import cloud.folium.spring.announcer.Announcer;
import cloud.folium.spring.factory.ObjectFactory;
import cloud.folium.spring.policeman.Policeman;
import cloud.folium.spring.room.Room;

public class CoronaDisinfector {

    private Announcer announcer = ObjectFactory.getInstance().createObject(Announcer.class);
    private Policeman policeman = ObjectFactory.getInstance().createObject(Policeman.class);

    public void start(Room room){
        announcer.announce("Start");
        policeman.makePeopleLeaveRoom();
        disinfect(room);
        announcer.announce("End");
    }

    private void disinfect(Room room) {
        System.out.println("disinfect");
    }
}
