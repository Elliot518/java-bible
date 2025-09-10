package zeus.playground.io.property;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: FileStreamPropertyDemo
 * @Package zeus.playground.io.property
 * @Description: read property by FileInputStream demo
 * @date 2018/5/25 15:14
 */
public class FileStreamPropertyDemo {
    public static void main(String[] args) {
        String PROPERTIES_NAME = "src/main/resources/properties/db.properties";
        String DB_DRIVER = null;
        String DB_URL = null;
        String DB_USER = null;
        String DB_PWD = null;

//        FileInputStream in = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PROPERTIES_NAME))) {
            Properties properties = new Properties();
            //in = new FileInputStream(new File(PROPERTIES_NAME));
            properties.load(bufferedReader);
            DB_DRIVER = properties.getProperty("driver");
            DB_URL = properties.getProperty("url");
            DB_USER = properties.getProperty("username");
            DB_PWD = properties.getProperty("passworld");
            System.out.println("读取配置信息成功！");

            System.out.println("-----------------------配置信息-----------------");
            System.out.println("dirver: " + DB_DRIVER);
            System.out.println("url: " + DB_URL);
            System.out.println("user: " + DB_USER);
            System.out.println("passworld: " + DB_PWD);
            System.out.println("----------------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("读取配置信息失败！");
        }
//        finally {
//            if (in != null) {
//                try {
//                    in.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }
}
