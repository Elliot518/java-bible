package zeus.playground.proxy.compile;

import zeus.playground.proxy.domain.Person;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: MyProxy
 * @Package zeus.playground.proxy.compile
 * @Description: static proxy
 * @date 2018/8/8 14:05
 */
public class MyProxy implements Person {
    private Person person;

    public MyProxy(Person person){
        this.person = person;
    }

    @Override
    public void sayHello(String content, int age) {
        System.out.println("MyProxy sayHello begin");

        //在代理类的方法中 间接访问被代理对象的方法
        person.sayHello(content, age);

        System.out.println("MyProxy sayHello end");
    }

    @Override
    public void sayGoodBye(boolean seeAgin, double time) {
        System.out.println("MyProxy sayGoodBye begin");

        //在代理类的方法中 间接访问被代理对象的方法
        person.sayGoodBye(seeAgin, time);

        System.out.println("MyProxy sayGoodBye end");
    }
}

