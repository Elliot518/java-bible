package zeus.playground.proxy.dynamic;

import zeus.playground.proxy.compile.Student;
import zeus.playground.proxy.domain.Person;

import java.lang.reflect.Proxy;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: MyInvocationHandlerTest
 * @Package zeus.playground.proxy.dynamic
 * @Description: my dynamic proxy test
 * @date 2018/8/8 14:25
 */
public class MyInvocationHandlerTest {
    public static void main(String[] args) {
        //创建需要被代理的类
        Student s = new Student();

        //这一句是生成代理类的class文件，前提是你需要在工程根目录下创建com/sun/proxy目录，不然会报找不到路径的io异常
        //System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        //获得加载被代理类的 类加载器
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        //指明被代理类实现的接口
        Class<?>[] interfaces = s.getClass().getInterfaces();
        // 创建被代理类的委托类,之后想要调用被代理类的方法时，都会委托给这个类的invoke(Object proxy, Method method, Object[] args)方法
        MyInvocationHandler h = new MyInvocationHandler(s);

        //生成代理类
        Person proxy = (Person) Proxy.newProxyInstance(loader, interfaces, h);

        //通过代理类调用 被代理类的方法
        proxy.sayHello("Master HaKu", 20);
        System.out.println("#####################################################");
        proxy.sayGoodBye(true, 100);
        System.out.println("end");
    }
}

