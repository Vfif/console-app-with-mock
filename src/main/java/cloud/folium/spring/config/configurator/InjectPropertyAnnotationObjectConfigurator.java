package cloud.folium.spring.config.configurator;

import cloud.folium.spring.annotation.InjectProperty;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InjectPropertyAnnotationObjectConfigurator implements ObjectConfigurator {

    Map<String, String> properties;

    @SneakyThrows
    public InjectPropertyAnnotationObjectConfigurator(){
        String path = ClassLoader.getSystemClassLoader().getResource("application.properties").getPath();
        Stream<String> lines = new BufferedReader(new FileReader(path)).lines();
        properties = lines.map(line -> line.split("=")).collect(Collectors.toMap(arr -> arr[0], arr -> arr[1]));
    }

    @Override
    @SneakyThrows
    public void configure(Object t) {
        Class<?> implClass = t.getClass();
        for (Field field: implClass.getDeclaredFields()) {
            InjectProperty annotation = field.getAnnotation(InjectProperty.class);

            if (annotation != null) {
                String value;
                if (annotation.value().isEmpty()) {
                    value = properties.get(field.getName());
                } else {
                    value = properties.get(annotation.value());
                }
                field.setAccessible(true);
                field.set(t, value);
            }
        }
    }
}
