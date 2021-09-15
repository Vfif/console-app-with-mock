package cloud.folium.spring.recommendator;

import cloud.folium.spring.annotation.InjectProperty;
import cloud.folium.spring.annotation.Singleton;

@Singleton
//@Deprecated
public class RecommendatorImpl implements Recommendator {
    @ InjectProperty("wisky")
    private String alcohol;

    @Override
    public void recommend() {
        System.out.println("Drink " + alcohol);
    }
}
