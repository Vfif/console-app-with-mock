package cloud.folium.spring.context;

import cloud.folium.spring.config.JavaConfig;
import cloud.folium.spring.factory.ObjectFactory;

import java.util.Map;

public class Application {
    public static ApplicationContext run(String packageToScan, Map<Class, Class> interfaceToClass) {
        JavaConfig config = new JavaConfig(packageToScan, interfaceToClass);
        ApplicationContext context = new ApplicationContext(config);
        ObjectFactory objectFactory = new ObjectFactory(context);

        context.setFactory(objectFactory);
        return context;
    }
}
