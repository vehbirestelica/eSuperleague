package mainS;

import mainS.Main;

import java.awt.Color;
import java.io.File;
import java.net.ServerSocket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import function.Client;
import function.Method;
import function.RemoteMethod;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

public class Main extends javax.swing.JFrame {

    public Main() {
    	setTitle("E - Super LIGA");
    	getContentPane().setBackground(SystemColor.activeCaption);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        cmdStart = new javax.swing.JButton();
        cmdStop = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextArea();
        lbStatus = new javax.swing.JLabel();
        lbStatus.setFont(new Font("Tw Cen MT", Font.BOLD, 14));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmdStart.setBackground(new java.awt.Color(102, 255, 102));
        cmdStart.setText("Start Server");
        cmdStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdStartActionPerformed(evt);
            }
        });

        cmdStop.setBackground(new java.awt.Color(255, 153, 153));
        cmdStop.setText("Stop Server");
        cmdStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdStopActionPerformed(evt);
            }
        });

        txt.setEditable(false);
        txt.setColumns(20);
        txt.setRows(5);
        jScrollPane1.setViewportView(txt);

        lbStatus.setForeground(new java.awt.Color(255, 51, 51));
        lbStatus.setText("Server is Stop");
        
        lblEsuperligaServer = new JLabel("E-SUPERLIGA SERVER");
        lblEsuperligaServer.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
        lblEsuperligaServer.setForeground(SystemColor.infoText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(40)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(cmdStop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(cmdStart, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
        					.addGap(49)
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(lbStatus, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
        					.addGap(248)
        					.addComponent(lblEsuperligaServer, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblEsuperligaServer, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbStatus, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
        			.addGap(9)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
        				.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        					.addGap(129)
        					.addComponent(cmdStart, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
        					.addGap(31)
        					.addComponent(cmdStop, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
    }

    private ServerSocket server;
    private Thread run; //Kena perdor threada per me ju pergjigj disa klienteve ne te njejten kohe
    //Threadat krijohen : Duke bere extend klasen Thread DHE duke implementu interfejsin Runnable

    private void startServer() throws Exception {
        Method.setClients(new ArrayList<>()); //per me shume klienta
        File f = new File("data");
//        for (File fs : f.listFiles()) {
//            fs.delete();
//        }
        run = new Thread(new Runnable() {//Eshte nje menyre e krijimit te threadit
            @Override
            public void run() { // perdoret per me performu naj veprim per thread
                try {
                    server = new ServerSocket(5000); //Serveri starton ne porten 5000 - TCP(connection-oriented)-reliabile
  //skena perdor UDP(connection-less) sepse nuk eshte reliabile sikur TCP dhe nese lidhja eshte e dobet atehere UDP paketat mund te humbin pa lene ndonje gjurme ose te arrijne ne nje renditje te gabuar
                    Registry registry = LocateRegistry.createRegistry(5001);//LocateRegistry-create a remote object registry that accepts calls on a specific port.
               //createRegistry(porti)-krijon dhe eksporton nje instane Registry ne lokalhost qe pranon kerkesa ne portin specifik
                     //Registry-remote interface qe siguron metoda per ruatjen dhe marrjen e remote object reference i lidhur me emra arbitar string
                    registry.bind("shiko userin", new RemoteMethod());//ben lidhjen e nje remote reference ne nje emer specifik ne kete regjister
                    lbStatus.setForeground(Color.GREEN);
                    Method.setTxt(txt);
                    txt.setText("Server now Starting ...\n");
                    while (true) {
                        new Client(server.accept()); //tani serveri do te pranoje konektimet e klienteve ne te
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(Main.this, e, "Error", JOptionPane.ERROR_MESSAGE);
                    //e.printStackTrace();
                }
            }
        });
        run.start();
    }

    private void stopServer() throws Exception {
        int c = JOptionPane.showConfirmDialog(this, "Are you sure to stop server now", "Sotop Server", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (c == JOptionPane.YES_OPTION) {
            lbStatus.setForeground(new Color(255, 51, 51));
            txt.setText("Server now Stoped ...");
            run.interrupt(); //Nje thread i bene request threadit tjeter me ndalu
            //me kete metode behet interrupt status state as true,ku e sinjalizon threadin me ndalu se shpejti
            server.close();
        }
    }
    private void cmdStartActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int c = JOptionPane.showConfirmDialog(this, "File in data will be delete when server is start", "Start Server", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (c == JOptionPane.YES_OPTION) {
                startServer();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cmdStopActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            stopServer();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    private javax.swing.JButton cmdStart;
    private javax.swing.JButton cmdStop;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JTextArea txt;
    private JLabel lblEsuperligaServer;
}
