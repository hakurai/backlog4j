package backlog4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author eguchi
 */
public final class XmlRpcUtil {

    private XmlRpcUtil() {
    }

    public static <T> List<T> toList(Class<T> clazz, Object[] objects) {
        if(objects==null){
            return Collections.emptyList();
        }
        List<T> list = new ArrayList<T>(objects.length);

        Constructor<T> constructor;
        try {
            constructor = clazz.getConstructor(Map.class);
        } catch (NoSuchMethodException e) {
            throw new BacklogException(e);
        }

        for (Object o : objects) {
            Map<String, Object> map = (Map<String, Object>) o;

            T t;
            try {
                t = constructor.newInstance(map);
            } catch (InstantiationException e) {
                throw new BacklogException(e);
            } catch (IllegalAccessException e) {
                throw new BacklogException(e);
            } catch (InvocationTargetException e) {
                throw new BacklogException(e);
            }

            list.add(t);
        }

        return Collections.unmodifiableList(list);
    }

    public static <T> List<T> toList( Class<T> clazz, Object o){
        return toList(clazz, (Object[])o);
    }

    public static String castToString(Object o) {
        return o == null ? "" : (String) o;
    }
}
