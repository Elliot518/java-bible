package zeus.playground.swing.component.tree.editable;

import java.awt.*;
import javax.swing.*;

/**
 * This program demonstrates tree editing.
 *
 * @author Cay Horstmann
 * @version 1.04 2016-05-10
 */
public class TreeEditTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new TreeEditFrame();
            frame.setTitle("TreeEditTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}