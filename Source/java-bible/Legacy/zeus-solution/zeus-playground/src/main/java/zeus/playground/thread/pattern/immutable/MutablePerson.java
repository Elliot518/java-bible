package zeus.playground.thread.pattern.immutable;

/**
 * @author: KG
 * @description:
 * @date: Created in 9:40 下午 2020/5/12
 * @modified by:
 */

public class MutablePerson {
    private String name;
    private String address;

    public MutablePerson(String name, String address) {
        this.name = name;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "MutablePerson{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
