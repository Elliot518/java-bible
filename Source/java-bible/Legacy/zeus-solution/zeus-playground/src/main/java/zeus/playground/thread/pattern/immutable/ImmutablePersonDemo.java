package zeus.playground.thread.pattern.immutable;

/**
 * @author: KG
 * @description:
 * @date: Created in 9:38 下午 2020/5/12
 * @modified by:
 */

public class ImmutablePersonDemo {
    public static void main(String[] args) {
        ImmutablePerson alice = new ImmutablePerson("Alice", "Alaska");
        for (int i = 0; i < 5; i++) {
            new ImmutablePersonThread(alice).start();
        }
    }
}
