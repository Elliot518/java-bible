package com.mcp.lab.third.poi;


import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年08月11日 2:51 PM
 * @modified by:
 */
public class ReadWordDemo1 {
    /**
     * 读取word文件内容
     * @param path
     * @return buffer
     */

    public String readWord(String path) {
        String buffer = "";

        if (path.endsWith(".doc")) {
            try (InputStream is = new FileInputStream(new File(path))) {

                WordExtractor ex = new WordExtractor(is);
                buffer = ex.getText();
                ex.close();
            } catch (Exception ex) {

            }
        } else if (path.endsWith("docx")) {
            try (OPCPackage opcPackage = POIXMLDocument.openPackage(path)) {
                POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
                buffer = extractor.getText();
                extractor.close();
            } catch (Exception ex) {

            }
        } else {
            System.out.println("此文件不是word文件！");
        }

        return buffer;
    }

    public static void main(String[] args) {
        String filePath = "/Users/kg/Downloads/test.docx";
        //String filePath= "/Users/kg/Downloads/本地验签操作手册.docx";

        ReadWordDemo1 tp = new ReadWordDemo1();
        String content = tp.readWord(filePath);

        // 将内容区域的回车换行去除
        content = content.replaceAll("[\\t\\n\\r]", "  ");

        System.out.println("Content:");
        System.out.println(content);
    }
}
