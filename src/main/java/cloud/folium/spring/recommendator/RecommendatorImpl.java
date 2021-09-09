package cloud.folium.spring.recommendator;

import cloud.folium.spring.annotation.InjectProperty;

public class RecommendatorImpl implements Recommendator {
    @ InjectProperty
    private String alcohol;

    @Override
    public void recommend() {
        System.out.println("Drink " + alcohol);
    }
}