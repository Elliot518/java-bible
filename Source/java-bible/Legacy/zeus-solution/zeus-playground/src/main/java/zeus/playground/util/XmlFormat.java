package zeus.playground.util;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.StringWriter;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: XmlFormat
 * @Package com.jnj.autocloud.common.util.xml.dom4j
 * @Description: xml format with dom4j
 * @date 2018/9/10 16:16
 */
public class XmlFormat {
    public static String formatXml(String str) throws Exception {
        Document document = null;
        document = DocumentHelper.parseText(str);
        // 格式化输出格式
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("gb2312");
        StringWriter writer = new StringWriter();
        // 格式化输出流
        XMLWriter xmlWriter = new XMLWriter(writer, format);
        // 将document写入到输出流
        xmlWriter.write(document);
        xmlWriter.close();

        return writer.toString();
    }
}

