package zeus.playground.swing.progress.monitor;

import java.awt.*;
import javax.swing.*;

/**
 * A program to test a progress monitor dialog.
 *
 * @author Cay Horstmann
 * @version 1.05 2016-05-10
 */
public class ProgressMonitorTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new ProgressMonitorFrame();
            frame.setTitle("ProgressMonitorTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}