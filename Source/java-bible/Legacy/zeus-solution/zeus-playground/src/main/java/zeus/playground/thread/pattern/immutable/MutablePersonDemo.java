package zeus.playground.thread.pattern.immutable;

/**
 * @author: KG
 * @description:
 * @date: Created in 9:38 下午 2020/5/12
 * @modified by:
 */

public class MutablePersonDemo {
    public static void main(String[] args) {
        MutablePerson alice = new MutablePerson("Alice", "Alaska");
        MutablePerson bob = new MutablePerson("Bob", "BeiJing");
        MutablePerson cindy =new MutablePerson("Cindy", "Canada");
        new MutablePersonThread(alice).start();
        new MutablePersonThread(bob).start();
        new MutablePersonThread(cindy).start();
    }
}
