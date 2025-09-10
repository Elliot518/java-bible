package zeus.playground.swing.layout.gridbag;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * A frame that uses a grid bag layout to arrange font selection components.
 */
public class FontFrame extends JFrame {
    public static final int TEXT_ROWS = 20;
    public static final int TEXT_COLUMNS = 40;

    private JComboBox<String> face;
    private JComboBox<Integer> size;
    private JCheckBox bold;
    private JCheckBox italic;
    private JTextArea sample;
    private JTable table;

    private String[] columnNames = {"Planet", "Radius", "Moons", "Gaseous", "Color"};
    private Object[][] cells = {{"Mercury", 2440.0, 0, false, Color.YELLOW},
            {"Venus", 6052.0, 0, false, Color.YELLOW}, {"Earth", 6378.0, 1, false, Color.BLUE},
            {"Mars", 3397.0, 2, false, Color.RED}, {"Jupiter", 71492.0, 16, true, Color.ORANGE},
            {"Saturn", 60268.0, 18, true, Color.ORANGE},
            {"Uranus", 25559.0, 17, true, Color.BLUE}, {"Neptune", 24766.0, 8, true, Color.BLUE},
            {"Pluto", 1137.0, 1, false, Color.BLACK}};

    public FontFrame() {
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);

        ActionListener listener = event -> updateSample();

        // construct components

        JLabel faceLabel = new JLabel("Face: ");

        face = new JComboBox<>(new String[]{"Serif", "SansSerif", "Monospaced",
                "Dialog", "DialogInput"});

        face.addActionListener(listener);

        JLabel sizeLabel = new JLabel("Size: ");

        size = new JComboBox<>(new Integer[]{8, 10, 12, 15, 18, 24, 36, 48});

        size.addActionListener(listener);

        bold = new JCheckBox("Bold");
        bold.addActionListener(listener);

        italic = new JCheckBox("Italic");
        italic.addActionListener(listener);

        sample = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
        sample.setText("The quick brown fox jumps over the lazy dog");
        sample.setEditable(false);
        sample.setLineWrap(true);
        sample.setBorder(BorderFactory.createEtchedBorder());

        table = new JTable(cells, columnNames);
        table.setAutoCreateRowSorter(true);

        /*sample2 = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
        sample2.setText("Sample text 2");
        sample2.setEditable(false);
        sample2.setLineWrap(true);
        sample2.setBorder(BorderFactory.createEtchedBorder());*/

        // add components to grid, using GBC convenience class

        add(faceLabel, new GBC(0, 0).setAnchor(GBC.EAST));
        add(face, new GBC(1, 0).setFill(GBC.HORIZONTAL).setWeight(100, 0)
                .setInsets(1));
        add(sizeLabel, new GBC(0, 1).setAnchor(GBC.EAST));
        add(size, new GBC(1, 1).setFill(GBC.HORIZONTAL).setWeight(100, 0)
                .setInsets(1));
        add(bold, new GBC(0, 2, 2, 1).setAnchor(GBC.CENTER).setWeight(100, 100));
        add(italic, new GBC(0, 3, 2, 1).setAnchor(GBC.CENTER).setWeight(100, 100));
        add(sample, new GBC(2, 0, 1, 2).setFill(GBC.BOTH).setWeight(100, 50));
        add(new JScrollPane(table), new GBC(2, 2, 1, 2).setFill(GBC.BOTH).setWeight(100, 50));
        pack();
        updateSample();
    }

    public void updateSample() {
        String fontFace = (String) face.getSelectedItem();
        int fontStyle = (bold.isSelected() ? Font.BOLD : 0)
                + (italic.isSelected() ? Font.ITALIC : 0);
        int fontSize = size.getItemAt(size.getSelectedIndex());
        Font font = new Font(fontFace, fontStyle, fontSize);
        sample.setFont(font);
        sample.repaint();
    }
}