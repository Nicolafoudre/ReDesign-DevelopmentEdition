
package arpus.redesign.pack;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Nicolas Olive-Leriche - Arpus
 */

public class RDMain extends JFrame {

    public static JFrame rdFrame;

    private JPanel rdMainPane;
    private JPanel rdTopPane;
    private JPanel rdBotPane;

    private JButton xButton;
    private JButton iconButton;
    private JButton maximinButton;

    Icon icon = new ImageIcon("D:\\logo-dcad.png");

    private JMenuBar rdMenuBar;
    private JMenu rdLogo = new JMenu("");
    private JMenu File = new JMenu("File");
    private JMenu Edit = new JMenu("Edit");
    private JMenu View = new JMenu("View");
    private JMenu Design = new JMenu("Design");
    private JMenu Tools = new JMenu("Tools");
    private JMenu Help = new JMenu("Help");

    private JMenuItem restore = new JMenuItem("Restore");
    private JMenuItem minimize = new JMenuItem("Minimize");
    private JMenuItem maximize = new JMenuItem("Maximize");
    private JMenuItem close = new JMenuItem("Close");

    private JMenuItem newFile = new JMenuItem("New part");
    private JMenuItem openFile = new JMenuItem("Open part");
    private JMenuItem openRecentFile = new JMenuItem("Open recent part");
    private JMenuItem closeFile = new JMenuItem("Close part");
    private JMenuItem newAssembly = new JMenuItem("New assembly");
    private JMenuItem openAssembly = new JMenuItem("Open assembly");
    private JMenuItem openRecentAssembly = new JMenuItem("Open recent assembly");
    private JMenuItem closeAssembly = new JMenuItem("Close assembly");
    private JMenuItem settings = new JMenuItem("Settings");
    private JMenuItem properties = new JMenuItem("Properties");
    private JMenuItem saveFile = new JMenuItem("Save file");
    private JMenuItem saveAs = new JMenuItem("Save as");
    private JMenuItem exit = new JMenuItem("Exit");

    private JMenuItem undo = new JMenuItem("Undo");
    private JMenuItem redo = new JMenuItem("Redo");
    private JMenuItem cut = new JMenuItem("Cut");
    private JMenuItem copy = new JMenuItem("Copy");
    private JMenuItem paste = new JMenuItem("Paste");
    private JMenuItem delete = new JMenuItem("Delete");
    private JMenuItem refresh = new JMenuItem("Refresh");
    private JMenuItem select = new JMenuItem("Select");
    private JMenuItem selectAll = new JMenuItem("Select all");

    private JMenu toolWindow = new JMenu("Tool windows");
    private JMenuItem fixedTree = new JMenuItem("Tree");
    private JMenuItem partCode = new JMenuItem("Part code");
    private JMenu appearance = new JMenu("Appearance");
    private JMenuItem normalMode = new JMenuItem("Normal mode");
    private JMenuItem windowMode = new JMenuItem("Windows Mode");
    private JMenuItem distractionlessMode = new JMenuItem("Distractionless mode");
    private JMenuItem customMode = new JMenuItem("Custom mode - Plugins/themes");
    private JMenuItem zoom = new JMenuItem("Zoom");
    private JMenu tree = new JMenu("Tree");
    private JMenuItem partBranch = new JMenuItem("Part Branches");
    private JMenuItem allBranch = new JMenuItem("All Branches");
    private JMenu splitView = new JMenu("Split view");
    private JMenuItem horizontalSplitView = new JMenuItem("Horizontal split view");
    private JMenuItem verticalSplitView = new JMenuItem("Vertical split view");
    private JMenuItem viewManager = new JMenuItem("View manager");

    private JMenuItem point = new JMenuItem("Point");
    private JMenuItem line = new JMenuItem("Line");
    private JMenuItem axe = new JMenuItem("Axe");
    private JMenuItem circle = new JMenuItem("Circle");
    private JMenuItem arc = new JMenuItem("Arc");
    private JMenu geometry = new JMenu("Geometry");
    private JMenuItem symmetry = new JMenuItem("Symmetry");
    private JMenuItem rotation = new JMenuItem("Rotation");
    private JMenuItem deleteDraw = new JMenuItem("Delete");


    private Point compCoords;

    private int sizeChooser = 0;

    public RDMain(String title) {
        super(title);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(1800, 700));
        this.setContentPane(rdMainPane);
        this.setUndecorated(true);
        this.pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Point middle = new Point(screenSize.width / 2, screenSize.height / 2);
        Point newLocation = new Point(middle.x - (this.getWidth() / 2), middle.y - (this.getHeight() / 2));
        this.setLocation(newLocation);

        rdMainPane.setBackground(new Color(10, 10, 25));
        System.out.println(rdMainPane);
        rdTopPane.setBackground(new Color(8, 8, 17));
        System.out.println(rdTopPane);
        System.out.println(rdBotPane);


        rdMenuBar.setOpaque(false);
        rdMenuBar.setBorder(null);
        rdMenuBar.add(rdLogo);
        System.out.println("Redesign logo path : " + icon);
        rdLogo.setIcon(icon);
        rdLogo.setOpaque(false);
        rdMenuBar.add(File);
        File.setOpaque(false);
        rdMenuBar.add(Edit);
        Edit.setOpaque(false);
        rdMenuBar.add(View);
        View.setOpaque(false);
        rdMenuBar.add(Design);
        Design.setOpaque(false);
        rdMenuBar.add(Tools);
        Tools.setOpaque(false);
        rdMenuBar.add(Help);
        Help.setOpaque(false);

        rdLogo.add(restore);
        rdLogo.add(minimize);
        minimize.addActionListener(actionEvent -> {
            rdFrame.resize(new Dimension(1800, 700));
        });
        rdLogo.add(maximize);
        maximize.addActionListener(actionEvent -> {
            rdFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        });
        rdLogo.addSeparator();
        rdLogo.add(close);
        close.addActionListener(actionEvent -> {
            System.out.println("System closing...");
            System.exit(0);
        });

        File.add(newFile);
        File.add(openFile);
        File.add(openRecentFile);
        File.add(closeFile);
        File.addSeparator();
        File.add(newAssembly);
        File.add(openAssembly);
        File.add(openRecentAssembly);
        File.add(closeAssembly);
        File.addSeparator();
        File.add(settings);
        settings.addActionListener(actionEvent -> {
            this.setEnabled(false);
            String[] args = {};
            Settings.main(args);
            Settings.sFrame.setLocationRelativeTo(rdMainPane);
        });
        File.add(properties);
        File.addSeparator();
        File.add(saveFile);
        File.add(saveAs);
        File.addSeparator();
        File.add(exit);
        exit.addActionListener(actionEvent -> {
            System.out.println("System closing...");
            System.exit(0);
        });

        Edit.add(undo);
        Edit.add(redo);
        Edit.addSeparator();
        Edit.add(cut);
        Edit.add(copy);
        Edit.add(paste);
        Edit.add(delete);
        Edit.addSeparator();
        Edit.add(refresh);
        Edit.add(select);
        Edit.add(selectAll);

        View.add(toolWindow);
        toolWindow.add(fixedTree);
        toolWindow.add(partCode);
        View.add(appearance);
        appearance.add(normalMode);
        appearance.add(windowMode);
        appearance.add(distractionlessMode);
        appearance.add(customMode);
        View.addSeparator();
        View.add(zoom);
        View.add(tree);
        tree.add(partBranch);
        tree.add(allBranch);
        View.addSeparator();
        View.add(splitView);
        splitView.add(horizontalSplitView);
        splitView.add(verticalSplitView);
        splitView.add(viewManager);

        Design.add(point);
        Design.add(line);
        Design.add(axe);
        Design.add(circle);
        Design.add(arc);
        Design.addSeparator();
        Design.add(geometry);
        geometry.add(symmetry);
        geometry.add(rotation);
        Design.addSeparator();
        Design.add(deleteDraw);


        maximinButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                maximinButton.setBackground(new Color(92, 95, 97));
                maximinButton.setForeground(new Color(255, 255, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                maximinButton.setBackground(new Color(12, 14, 21));
                maximinButton.setForeground(new Color(187, 187, 187));
            }
        });
        maximinButton.addActionListener(actionEvent -> {
            sizeChooser = sizeChooser + 1;
            System.out.println(sizeChooser);
            if (sizeChooser % 2 == 0) {
                rdFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                maximinButton.setText(".");
            } else {
                rdFrame.resize(new Dimension(1800, 700));
                maximinButton.setText("+");
            }
        });

        iconButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                iconButton.setBackground(new Color(92, 95, 97));
                iconButton.setForeground(new Color(255, 255, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                iconButton.setBackground(new Color(12, 14, 21));
                iconButton.setForeground(new Color(187, 187, 187));
            }
        });
        iconButton.addActionListener(actionEvent -> {
            rdFrame.setState(ICONIFIED);
        });

        xButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                xButton.setBackground(new Color(255, 5, 5));
                xButton.setForeground(new Color(255, 255, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                xButton.setBackground(new Color(12, 14, 21));
                xButton.setForeground(new Color(187, 187, 187));
            }
        });
        xButton.addActionListener(actionEvent -> {
            System.out.println("System closing...");
            System.exit(0);
        });

        compCoords = null;
        rdTopPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                compCoords = e.getPoint();
                System.out.println("Frame position : " + compCoords);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                compCoords = null;
            }
        });
        rdTopPane.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point framCoords = e.getLocationOnScreen();
                rdFrame.setLocation(framCoords.x - compCoords.x, framCoords.y - compCoords.y);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarculaLaf");
        } catch (Exception e) {
            System.out.println("Failed to initialize UI theme...");
        }
        rdFrame = new RDMain("ReDesign");
        rdFrame.setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        rdMainPane = new JPanel();
        rdMainPane.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        rdMainPane.setBackground(new Color(-16119271));
        rdTopPane = new JPanel();
        rdTopPane.setLayout(new GridLayoutManager(1, 6, new Insets(0, 0, 0, 0), -1, -1));
        rdTopPane.setBackground(new Color(-16250863));
        rdMainPane.add(rdTopPane, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        rdMenuBar = new JMenuBar();
        rdTopPane.add(rdMenuBar, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        rdTopPane.add(spacer1, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setForeground(new Color(-10723487));
        label1.setText("ReDesign");
        rdTopPane.add(label1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        xButton = new JButton();
        xButton.setBorderPainted(false);
        xButton.setContentAreaFilled(false);
        xButton.setFocusPainted(false);
        xButton.setOpaque(true);
        xButton.setText("X");
        rdTopPane.add(xButton, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        maximinButton = new JButton();
        maximinButton.setBorderPainted(false);
        maximinButton.setContentAreaFilled(false);
        maximinButton.setFocusPainted(false);
        maximinButton.setOpaque(true);
        maximinButton.setText("+");
        rdTopPane.add(maximinButton, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        iconButton = new JButton();
        iconButton.setBorderPainted(false);
        iconButton.setContentAreaFilled(false);
        iconButton.setEnabled(true);
        iconButton.setOpaque(true);
        iconButton.setText("-");
        rdTopPane.add(iconButton, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        rdMainPane.add(spacer2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        rdBotPane = new JPanel();
        rdBotPane.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        rdBotPane.setBackground(new Color(-16645961));
        rdMainPane.add(rdBotPane, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        rdBotPane.add(spacer3, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setForeground(new Color(-10723487));
        label2.setText("    ");
        rdBotPane.add(label2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rdMainPane;
    }

}
