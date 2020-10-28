
import java.awt.Dimension;
import java.io.*;

public class DHMain extends javax.swing.JFrame {

    public DHMain() {
        initComponents();
        //jDesktopPane1.add( new DHFrame());
        java.awt.Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setSize(610, 455);
        setResizable(false);
    }

    private void initComponents() {

        jdp = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenuItem(); //File
        //item.setPreferredSize(new Dimension(200, item.getPreferredSize().height));
        fileMenu.setSize(new Dimension(0,fileMenu.getPreferredSize().height));
        fileMenu1 = new javax.swing.JMenuItem(); //Help

        embedMenu = new javax.swing.JMenu();
        extractmenu = new javax.swing.JMenu();
        //exitmenu = new javax.swing.JMenuItem();
        //aboutMenu = new javax.swing.JMenuItem();
        piclabel = new javax.swing.JLabel(new javax.swing.ImageIcon("new2.jpg"));
        piclabel.setBounds(0, 0, 600, 400);
        add(piclabel);
        setTitle("Audio-Stego");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        getContentPane().add(jdp, java.awt.BorderLayout.CENTER);

        fileMenu.setMnemonic('m');
        fileMenu.setText("Embed");
        fileMenu1.setMnemonic('x');
        fileMenu1.setText("Extract");
//        embedMenu.setMnemonic('m');
//        embedMenu.setText("Embed");
        fileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                embedMenuActionPerformed(evt);
            }
        });
        fileMenu1.setMnemonic('t');
        fileMenu1.setText("Extract");
        fileMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extractmenuActionPerformed(evt);
            }
        });


        jMenuBar1.add(fileMenu);
        jMenuBar1.add(fileMenu1);

        setJMenuBar(jMenuBar1);
        pack();
    }

//    private void exitmenuActionPerformed(java.awt.event.ActionEvent evt) {
//
//        System.exit(0);
//    }

    private void extractmenuActionPerformed(java.awt.event.ActionEvent evt) {
        piclabel.setVisible(false);
        WizardFrame wf = new ExtractAction(this).getWizardFrame();
        jdp.add(wf);
        wf.moveToFront();
    }

    private void embedMenuActionPerformed(java.awt.event.ActionEvent evt) {

        System.out.println("Embed Action Selected..");

        piclabel.setVisible(false);
        WizardFrame wf = new EmbedAction(this).getWizardFrame();
        jdp.add(wf);
        wf.moveToFront();
    }



    private void exitForm(java.awt.event.WindowEvent evt) {

        System.exit(0);

    }

    public static void main(String args[]) {
        new DHMain().show();
    }

    private javax.swing.JMenuItem exitmenu;
    private javax.swing.JMenuItem fileMenu;
    private javax.swing.JMenuItem fileMenu1;
    private javax.swing.JDesktopPane jdp;
    private javax.swing.JMenuItem extractmenu;
    private javax.swing.JMenuItem embedMenu;
    private javax.swing.JMenuItem aboutMenu;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JLabel piclabel;

}
