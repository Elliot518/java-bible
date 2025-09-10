package zeus.xml;

import zeus.playground.util.XmlFormat;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: XmlDomFormatTest
 * @Package zeus.xml
 * @Description: xml dom format test
 * @date 2018/9/10 17:45
 */
public class XmlDomFormatTest {
    public static void main(String[] args) {
        String xml = "<adf-curation xmlPathPrefix=\"a\" executionClassName=\"test\"><regions><region path=\"elm/source_system_v1\" mainRegion=\"true\"><columns>a,b,c</columns><relations>123</relations></region>&#10;</regions></adf-curation>";

        try {
            xml = XmlFormat.formatXml(xml);
            System.out.println(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
