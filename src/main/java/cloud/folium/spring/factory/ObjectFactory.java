package cloud.folium.spring.factory;

import cloud.folium.spring.annotation.InjectProperty;
import cloud.folium.spring.config.Config;
import cloud.folium.spring.config.JavaConfig;
import cloud.folium.spring.policeman.KindPoliceman;
import cloud.folium.spring.policeman.Policeman;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ObjectFactory {
    private static ObjectFactory instance = new ObjectFactory();
    private Config config;

    public static ObjectFactory getInstance() {
        return instance;
    }

    private ObjectFactory() {
        this.config = new JavaConfig("cloud.folium.spring", new HashMap<>(Map.of(Policeman.class,
            KindPoliceman.class)));

    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> implClass = type;
        if (type.isInterface()) {
            implClass = config.getImplClass(type);
        }
        T t = implClass.getDeclaredConstructor().newInstance();
        for (Field field: implClass.getDeclaredFields()) {
            InjectProperty annotation = field.getAnnotation(InjectProperty.class);
            String path = ClassLoader.getSystemClassLoader().getResource("application.properties").getPath();

            Stream<String> lines = new BufferedReader(new FileReader(path)).lines();
            Map<String, String> properties = lines.map(line -> line.split("=")).collect(Collectors.toMap(arr -> arr[0], arr -> arr[1]));
            if (annotation != null) {
                String value;
                if (annotation.value().isEmpty()) {
                    value = properties.get(field.getName());
                } else {
                    value = properties.get(annotation.value());
                }
                field.set(t, value);
            }
        }
        return t;
    }
}
