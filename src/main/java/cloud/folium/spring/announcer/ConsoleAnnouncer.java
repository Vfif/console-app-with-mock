package cloud.folium.spring.announcer;

import cloud.folium.spring.annotation.InjectByType;
import cloud.folium.spring.recommendator.Recommendator;

import javax.annotation.PostConstruct;

public class ConsoleAnnouncer implements Announcer {
    @InjectByType
    private Recommendator recommendator;

    @PostConstruct
    public void init(){
        System.out.println(recommendator.getClass());
    }

    @Override
    public void announce(String message) {
        System.out.println(message);
        recommendator.recommend();
    }
}
