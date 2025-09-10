package zeus.test.infra.basic;

public class StringContainTest {
    public static void main(String[] args) {
        String destString = "玻璃更换劵福建";
        String keyword = "玻璃更换券";
        int index = destString.indexOf(keyword);
        System.out.println(index);
        if (index != -1) {
            System.out.println("包含");
        } else {
            System.out.println("不包含");
        }

        if (destString.contains(keyword)) {
            System.out.println("Contains");
        } else {
            System.out.println("Not Contains");
        }
    }
}

