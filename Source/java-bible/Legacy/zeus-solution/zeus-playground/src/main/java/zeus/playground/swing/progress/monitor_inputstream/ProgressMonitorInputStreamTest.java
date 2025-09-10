package zeus.playground.swing.progress.monitor_inputstream;

import java.awt.*;
import javax.swing.*;

/**
 * A program to test a progress monitor input stream.
 *
 * @author Cay Horstmann
 * @version 1.06 2016-05-10
 */
public class ProgressMonitorInputStreamTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new TextFrame();
            frame.setTitle("ProgressMonitorInputStreamTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}