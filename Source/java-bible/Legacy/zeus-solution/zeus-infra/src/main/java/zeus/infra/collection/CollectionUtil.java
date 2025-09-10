package zeus.infra.collection;

import java.util.Collection;

/**
 * Created by KG on 2017/6/26.
 */

public class CollectionUtil {
    public static <E> boolean contains(Collection<E> c, Object obj) {
        for (E element : c)
            if (element.equals(obj))
                return true;
        return false;
    }
}
