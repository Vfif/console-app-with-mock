package cloud.folium.spring.factory.configurator.proxy;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DeprecatedHandlerProxyConfigurator implements ProxyConfigurator {

    @Override
    public Object replaceWithProxyIfNeeded(Object t, Class implClass) {
        if (implClass.isAnnotationPresent(Deprecated.class)) {

            if (implClass.getInterfaces().length == 0) {
                return Enhancer.create(implClass, (net.sf.cglib.proxy.InvocationHandler)
                    (proxy, method, args) -> getInvocationHandlerLogic(method, args, t));
            }
            return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(),
                (proxy, method, args) -> getInvocationHandlerLogic(method, args, t));
        } else {
            return t;
        }

    }

    private Object getInvocationHandlerLogic(
        Method method,
        Object[] args,
        Object t
    ) throws IllegalAccessException, InvocationTargetException {
        System.out.println("proxy");
        return method.invoke(t, args);
    }
}
