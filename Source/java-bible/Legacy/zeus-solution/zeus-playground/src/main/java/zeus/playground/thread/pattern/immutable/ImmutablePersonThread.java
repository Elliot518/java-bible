package zeus.playground.thread.pattern.immutable;

/**
 * @author: KG
 * @description:
 * @date: Created in 9:43 下午 2020/5/12
 * @modified by:
 */

public class ImmutablePersonThread extends Thread {
    private ImmutablePerson person;

    public ImmutablePersonThread(ImmutablePerson person) {
        this.person = person;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " prints " + person);
        }
    }
}
