package zeus.playground.proxy.compile;

import zeus.playground.proxy.domain.Person;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: Student
 * @Package zeus.playground.proxy.compile
 * @Description: student inplement person
 * @date 2018/8/8 14:01
 */
public class Student implements Person {
    @Override
    public void sayHello(String content, int age) {
        // TODO Auto-generated method stub
        System.out.println("student say hello " + content + " " + age);
    }

    @Override
    public void sayGoodBye(boolean seeAgin, double time) {
        // TODO Auto-generated method stub
        System.out.println("student sayGoodBye " + time + " " + seeAgin);
    }

}

