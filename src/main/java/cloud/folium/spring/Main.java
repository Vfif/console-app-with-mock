package cloud.folium.spring;

import cloud.folium.spring.context.Application;
import cloud.folium.spring.context.ApplicationContext;
import cloud.folium.spring.policeman.KindPoliceman;
import cloud.folium.spring.policeman.Policeman;
import cloud.folium.spring.room.Room;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = Application.run("cloud.folium.spring", new HashMap<>(Map.of(Policeman.class, KindPoliceman.class)));
        CoronaDisinfector disinfector = context.getObject(CoronaDisinfector.class);
        disinfector.start(new Room());
    }
}
