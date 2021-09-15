package cloud.folium.spring.factory.configurator.proxy;

import cloud.folium.spring.context.ApplicationContext;

public interface ProxyConfigurator {

    Object replaceWithProxyIfNeeded(Object t, Class implClass);
}
