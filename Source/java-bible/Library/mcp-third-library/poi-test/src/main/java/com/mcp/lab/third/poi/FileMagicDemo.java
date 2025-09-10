package com.mcp.lab.third.poi;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author: KG
 * @description:
 * @date: Created in 2021年08月18日 10:05 AM
 * @modified by:
 */
public class FileMagicDemo {
    private static String readDoc(String filePath) {
        String text = "";

        try (InputStream is = new FileInputStream(new File(filePath))) {
            if (FileMagic.valueOf(is) == FileMagic.OLE2) {
                WordExtractor ex = new WordExtractor(is);
                text = ex.getText();
                ex.close();
            } else if (FileMagic.valueOf(is) == FileMagic.OOXML) {
                XWPFDocument doc = new XWPFDocument(is);
                XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
                text = extractor.getText();
                extractor.close();
            }
        } catch (Exception e) {
            //log.error("for file " + filePath, e);
        }

        return text;
    }

    public static void main(String[] args) {
        String content = readDoc("/Users/kg/Downloads/test.docx");

        System.out.println("Content:");
        System.out.println(content);
    }
}
