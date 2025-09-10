package zeus.playground.swing.component.tree.simple;

import java.awt.*;
import javax.swing.*;

/**
 * This program shows a simple tree.
 *
 * @author Cay Horstmann
 * @version 1.03 2016-05-10
 */
public class SimpleTree {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new SimpleTreeFrame();
            frame.setTitle("SimpleTree");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
