package zeus.test.json;

import zeus.json.GsonUtil;

import java.util.HashMap;

public class GsonTest {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Steve", "Jobs");
        map.put("Bill", "Gates");
        map.put("Jack", "Ma");

        String result = GsonUtil.mapToJson(map);
        System.out.println("Result: " + result);
    }
}
