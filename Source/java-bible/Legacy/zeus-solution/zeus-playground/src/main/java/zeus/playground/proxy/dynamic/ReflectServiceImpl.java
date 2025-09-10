package zeus.playground.proxy.dynamic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectServiceImpl {
	public void sayHello(String name) {
		System.err.println("Hello " + name);
	}

}