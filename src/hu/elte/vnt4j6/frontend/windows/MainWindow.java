/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.vnt4j6.frontend.windows;

import hu.elte.vnt4j6.frontend.components.HousesPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author lcsoka
 */
public class MainWindow extends JFrame {
    private static JPanel actionPanel;
//    private static HousesPanel contentPanel;
    
    public MainWindow()throws HeadlessException {
        initScreen();
    }
    
     private void initScreen() {
        setLayout(new FlowLayout());
//        contentPanel = new HousesPanel(this);
        actionPanel = new JPanel();
        add(actionPanel);
        setSize(500, 500);
        setTitle("Beadando");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println(getSize().width);
        System.out.println(getSize().height);
        this.getContentPane().setLayout(new GridLayout(1, 1));

        
    }
    
    
}
