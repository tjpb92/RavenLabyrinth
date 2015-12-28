/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cravenlabyrinth;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author Thierry Baribaud
 */


public class CravenLabyrinth {

    private static final int MUR = 0;
    private static final int CASE_LIBRE = 1;
    private static final int GEMME_ROUGE = 2;
    private static final int GEMME_BLEUE = 3;
    private static final int CORBEAU = 4;
    private static final int NORD = 11;
    private static final int EST = 21;
    private static final int SUD = 31;
    private static final int OUEST = 41;
    private static final int DEPART = 50;
    private static final int ARRIVEE = 60;

    private static final int LIGNES = 17;
    private static final int COLONNES = 23;
    
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        JFrame MyWindow;
        
        JPanel CommandPanel;
        JPanel PalettePanel;
        JPanel TopPanel;
        JPanel JeuPanel;
        JPanel DebugPanel;
        
        ImageIcon GemmeRougeIcon;
        ImageIcon GemmeBleueIcon;
        ImageIcon MurIcon;
        ImageIcon DalleIcon;
        ImageIcon CorbeauIcon;
        
        JLabel GemmeRougeLabel;
        JLabel GemmeBleueLabel;
        JLabel MurLabel;
        JLabel DalleLabel;
        JLabel CorbeauLabel;
        
        AgainButton Recommencer;
        SolveButton Resoudre;
        StopButton Arreter;
        
        GridBagConstraints GBC;
        int i;
        int j;
        
        Dalle[][] Dalles;
        
        GemmeRougeIcon = new ImageIcon("Images/gemme_rouge_32x31.png");
        GemmeBleueIcon = new ImageIcon("Images/gemme_bleue_32x29.png");
        MurIcon = new ImageIcon("Images/mur_32x32.jpg");
        DalleIcon = new ImageIcon("Images/dalle_32x32.jpg");
        CorbeauIcon = new ImageIcon("Images/corbeau_03_32x32.jpg");
        
        Recommencer = new AgainButton();
        Resoudre = new SolveButton();
        Arreter = new StopButton();
        
        MyWindow = new JFrame();
        MyWindow.setTitle("Enigme du corbeau et de la marelle");
        MyWindow.setPreferredSize(new Dimension(LARGEUR, HAUTEUR));
//        MyWindow.setLocationRelativeTo(null);
        MyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        CommandPanel = new JPanel();
        CommandPanel.setBackground(Color.red);
        CommandPanel.setLayout(new FlowLayout());        
        CommandPanel.setPreferredSize(new Dimension(LARGEUR, ICON_SIZE));
        CommandPanel.add(Recommencer);
        CommandPanel.add(Resoudre);
        CommandPanel.add(Arreter);
        
        PalettePanel = new JPanel();
        PalettePanel.setBackground(Color.blue);
        PalettePanel.setLayout(new FlowLayout());        
        PalettePanel.setPreferredSize(new Dimension(LARGEUR, ICON_SIZE));
        
        GemmeRougeLabel = new JLabel();
        GemmeRougeLabel.setIcon(GemmeRougeIcon);
        PalettePanel.add(GemmeRougeLabel);
        
        GemmeBleueLabel = new JLabel();
        GemmeBleueLabel.setIcon(GemmeBleueIcon);
        PalettePanel.add(GemmeBleueLabel);
       
        MurLabel = new JLabel();
        MurLabel.setIcon(MurIcon);
        PalettePanel.add(MurLabel);
        
        DalleLabel = new JLabel();
        DalleLabel.setIcon(DalleIcon);
        PalettePanel.add(DalleLabel);
        
        CorbeauLabel = new JLabel();
        CorbeauLabel.setIcon(CorbeauIcon);
        PalettePanel.add(CorbeauLabel);

        TopPanel = new JPanel();
        TopPanel.setBackground(Color.pink);
        TopPanel.setLayout(new GridLayout(2, 1));
        TopPanel.add(CommandPanel);
        TopPanel.add(PalettePanel);
        
        JeuPanel = new JPanel();
        JeuPanel.setBackground(Color.green);
        JeuPanel.setLayout(new GridLayout(LIGNES, COLONNES));
//        GBC = new GridBagConstraints();
//        GBC.gridheight = 1;
//        GBC.gridwidth = 1;
        
        Dalles = new Dalle[LIGNES][COLONNES];
        for(i = 0; i < LIGNES; i++) {
//            GBC.gridx = i;
            for(j = 0; j < COLONNES; j++) {
//                GBC.gridy = j;
                Dalles[i][j] = new Dalle();
                JeuPanel.add(Dalles[i][j]);
//                Thread.sleep(1000);
            }
        }
        
        i = 1;
        for (j=5; j < 18; j++) {
            Dalles[i][j].setStatus(CASE_LIBRE);
        }
        Dalles[i][11].setStatus(GEMME_ROUGE);
        
        i++;
        Dalles[i][5].setStatus(CASE_LIBRE);
        Dalles[i][17].setStatus(CASE_LIBRE);

        i++;
        Dalles[i][5].setStatus(GEMME_BLEUE);
        Dalles[i][17].setStatus(GEMME_BLEUE);

        i++;
        Dalles[i][5].setStatus(CASE_LIBRE);
        Dalles[i][17].setStatus(CASE_LIBRE);
        
        i++;
        for (j=1; j < 22; j++) {
            Dalles[i][j].setStatus(CASE_LIBRE);
        }
        Dalles[i][3].setStatus(GEMME_BLEUE);
        Dalles[i][7].setStatus(GEMME_BLEUE);
        Dalles[i][15].setStatus(GEMME_ROUGE);
        
        i++;
        Dalles[i][1].setStatus(CASE_LIBRE);
        Dalles[i][5].setStatus(CASE_LIBRE);
        Dalles[i][9].setStatus(CASE_LIBRE);
        Dalles[i][13].setStatus(CASE_LIBRE);
        Dalles[i][17].setStatus(CASE_LIBRE);
        Dalles[i][21].setStatus(CASE_LIBRE);
        
        i++;
        Dalles[i][1].setStatus(GEMME_ROUGE);
        Dalles[i][5].setStatus(GEMME_ROUGE);
        Dalles[i][9].setStatus(GEMME_ROUGE);
        Dalles[i][13].setStatus(GEMME_BLEUE);
        Dalles[i][17].setStatus(GEMME_ROUGE);
        Dalles[i][21].setStatus(GEMME_ROUGE);
        
        i++;
        Dalles[i][1].setStatus(CASE_LIBRE);
        Dalles[i][5].setStatus(CASE_LIBRE);
        Dalles[i][9].setStatus(CASE_LIBRE);
        Dalles[i][13].setStatus(CASE_LIBRE);
        Dalles[i][17].setStatus(CASE_LIBRE);
        Dalles[i][21].setStatus(CASE_LIBRE);

        i++;
        for (j=1; j < 10; j++) {
            Dalles[i][j].setStatus(CASE_LIBRE);
        }
        for (j=13; j < 22; j++) {
            Dalles[i][j].setStatus(CASE_LIBRE);
        }
        Dalles[i][3].setStatus(GEMME_BLEUE);
        Dalles[i][7].setStatus(GEMME_ROUGE);
        Dalles[i][15].setStatus(GEMME_ROUGE);
        Dalles[i][19].setStatus(GEMME_BLEUE);
        
        i++;
        Dalles[i][1].setStatus(CASE_LIBRE);
        Dalles[i][5].setStatus(CASE_LIBRE);
        Dalles[i][9].setStatus(CASE_LIBRE);
        Dalles[i][13].setStatus(CASE_LIBRE);
        Dalles[i][17].setStatus(CASE_LIBRE);
        Dalles[i][21].setStatus(CASE_LIBRE);

        i++;
        Dalles[i][1].setStatus(GEMME_BLEUE);
        Dalles[i][5].setStatus(GEMME_BLEUE);
        Dalles[i][9].setStatus(CASE_LIBRE);
        Dalles[i][13].setStatus(CASE_LIBRE);
        Dalles[i][17].setStatus(CASE_LIBRE);
        Dalles[i][21].setStatus(GEMME_BLEUE);
        
        i++;
        Dalles[i][1].setStatus(CASE_LIBRE);
        Dalles[i][5].setStatus(CASE_LIBRE);
        Dalles[i][9].setStatus(CASE_LIBRE);
        Dalles[i][13].setStatus(CASE_LIBRE);
        Dalles[i][17].setStatus(CASE_LIBRE);
        Dalles[i][21].setStatus(CASE_LIBRE);

        i++;
        for (j=1; j < 10; j++) {
            Dalles[i][j].setStatus(CASE_LIBRE);
        }
        for (j=13; j < 22; j++) {
            Dalles[i][j].setStatus(CASE_LIBRE);
        }
        Dalles[i][3].setStatus(GEMME_ROUGE);
        Dalles[i][19].setStatus(GEMME_ROUGE);
    
        i++;
        Dalles[i][1].setStatus(GEMME_ROUGE);
        Dalles[i][21].setStatus(GEMME_ROUGE);

        i++;
        Dalles[i][1].setStatus(CORBEAU);
        Dalles[i][21].setStatus(CASE_LIBRE);
        
        DebugPanel = new JPanel();
        DebugPanel.setBackground(Color.yellow);
        
        MyWindow.setLayout(new BorderLayout());
        MyWindow.getContentPane().add(TopPanel, BorderLayout.NORTH);
        MyWindow.getContentPane().add(JeuPanel, BorderLayout.CENTER);
        MyWindow.getContentPane().add(DebugPanel, BorderLayout.SOUTH);
        
        MyWindow.pack();
        MyWindow.setVisible(true);
    }
    private static final int ICON_SIZE = 32;  
    private static final int HAUTEUR = 664;
    private static final int LARGEUR = 736;
    
}