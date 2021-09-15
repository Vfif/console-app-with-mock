package cloud.folium.spring;

import cloud.folium.spring.annotation.InjectByType;
import cloud.folium.spring.announcer.Announcer;
import cloud.folium.spring.policeman.Policeman;
import cloud.folium.spring.room.Room;

public class CoronaDisinfector {

    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Policeman policeman;

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
