package cloud.folium.spring.factory.configurator;

import cloud.folium.spring.context.ApplicationContext;

public interface ObjectConfigurator {

    void configure(Object t, ApplicationContext context);
}
