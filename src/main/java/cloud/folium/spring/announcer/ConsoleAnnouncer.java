package cloud.folium.spring.announcer;

import cloud.folium.spring.factory.ObjectFactory;
import cloud.folium.spring.recommendator.Recommendator;

public class ConsoleAnnouncer implements Announcer {
    private Recommendator recommendator = ObjectFactory.getInstance().createObject(Recommendator.class);

    @Override
    public void announce(String message) {
        System.out.println(message);
        recommendator.recommend();
    }
}
