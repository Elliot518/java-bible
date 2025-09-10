package zeus.playground.thread.pattern.immutable;

/**
 * @author: KG
 * @description:
 * @date: Created in 9:40 下午 2020/5/12
 * @modified by:
 */

public final class ImmutablePerson {
    private final String name;
    private final String address;

    public ImmutablePerson(String name, String address) {
        this.name = name;
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
        return "ImmutablePerson{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
