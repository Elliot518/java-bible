package zeus.playground.swing.dialog;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.*;

/**
 * A frame with a menu whose File->About action shows a dialog.
 */
public class DialogFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 600;
    private static final int DLG_WIDTH = 400;
    private static final int DLG_HEIGHT = 300;
    private AboutDialog dialog;

    public DialogFrame() {
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(screensize.width / 2 - DEFAULT_WIDTH / 2, screensize.height / 2 - DEFAULT_HEIGHT / 2, DEFAULT_WIDTH, DEFAULT_HEIGHT);


        // Construct a File menu.

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        // Add About and Exit menu items.

        // The About item shows the About dialog.

        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(event -> {
            if (dialog == null) {
                // first time
                dialog = new AboutDialog(DialogFrame.this);
                dialog.setBounds(screensize.width / 2 - DLG_WIDTH / 2, screensize.height / 2 - DLG_HEIGHT / 2, DLG_WIDTH, DLG_HEIGHT);
            }
            dialog.setVisible(true); // pop up dialog
        });
        fileMenu.add(aboutItem);

        // The Exit item exits the program.

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(event -> System.exit(0));
        fileMenu.add(exitItem);
    }
}
