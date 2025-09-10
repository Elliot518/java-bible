package zeus.playground.model;

import java.time.LocalDateTime;

/**
 * @author: KG
 * @description:
 * @date: Created in 上午10:09 2018/4/28
 * @modified by:
 */

public class User {
    private int id;
    private String name;
    private LocalDateTime enrollDate;

    public User() {
        this.id = 0;
        this.name = "0";
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(LocalDateTime enrollDate) {
        this.enrollDate = enrollDate;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", enroll date=" + enrollDate + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (this == o) {
            return true;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        User otherUser = (User) o;

        return id == otherUser.id && name.equals(otherUser.name);
    }

    @Override
    public int hashCode() {
        return 13 * id + 17 * name.hashCode();
    }
}
