package zeus.infra.reflection;

import java.lang.reflect.Array;

/**
 * Created by KG on 2017/5/24.
 */
public class GenericReflector {
    /**
     * This method grows an array by allocating a new array of the same type and
     * copying all elements.
     * @param a the array to grow. This can be an object array or a primitive
     * type array
     * @return a larger array that contains all elements of a.
     */
    public static Object arrayCopy(Object a, int newLength)
    {
        Class cl = a.getClass();

        if (!cl.isArray()) return null;

        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));

        return newArray;
    }
}
