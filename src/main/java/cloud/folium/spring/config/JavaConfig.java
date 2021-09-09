package cloud.folium.spring.config;

import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class JavaConfig implements Config {

    private Reflections scanner;
    private Map<Class, Class> interfaceToClass;

    public JavaConfig(String packageToScan, Map<Class, Class> interfaceToClass) {
        this.scanner = new Reflections(packageToScan);
        this.interfaceToClass = interfaceToClass;
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> type) {
        return interfaceToClass.computeIfAbsent(type, aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
            if (classes.size() != 1) {
                throw new RuntimeException(type + "has 0 or more than one impl");
            }
            return classes.iterator().next();
        });
    }
}
