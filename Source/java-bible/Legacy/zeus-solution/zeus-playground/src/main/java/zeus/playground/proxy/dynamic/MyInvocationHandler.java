package zeus.playground.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: MyInvocationHandler
 * @Package zeus.playground.proxy.dynamic
 * @Description: my dynamic proxy
 * @date 2018/8/8 14:17
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object object;

    public MyInvocationHandler(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("MyInvocationHandler invoke begin");
        System.out.println("proxy: "+ proxy.getClass().getName());
        System.out.println("method: "+ method.getName());
        for(Object o : args){
            System.out.println("arg: "+ o);
        }

        //通过反射调用 被代理类的方法
        method.invoke(object, args);

        System.out.println("MyInvocationHandler invoke end");

        return null;

    }
}
