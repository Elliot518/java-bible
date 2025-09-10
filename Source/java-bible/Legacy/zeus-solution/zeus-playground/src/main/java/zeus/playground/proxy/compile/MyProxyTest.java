package zeus.playground.proxy.compile;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: MyProxyTest
 * @Package zeus.playground.proxy.compile
 * @Description: static proxy test
 * @date 2018/8/8 14:13
 */
public class MyProxyTest {
    public static void main(String[] args) {
        //s为被代理的对象，某些情况下 我们不希望修改已有的代码，我们采用代理来间接访问
        Student s = new Student();

        //创建代理类对象
        MyProxy proxy = new MyProxy(s);

        //调用代理类对象的方法
        proxy.sayHello("welcome to java", 20);
        System.out.println("**********************************");

        //调用代理类对象的方法
        proxy.sayGoodBye(true, 100);

    }

}
