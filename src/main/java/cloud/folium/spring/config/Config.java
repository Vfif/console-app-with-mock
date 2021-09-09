package cloud.folium.spring.config;

public interface Config {
    <T> Class<? extends T> getImplClass(Class<T> type);
}
