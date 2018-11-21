/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.vnt4j6.frontend.windows;

import hu.elte.vnt4j6.frontend.components.PersonalitiesPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author lcsoka
 */
public class PersonalityWindow extends JFrame {
    private Dimension size = new Dimension(300, 150);
    private String name;
    public PersonalityWindow() throws HeadlessException {
        initScreen();
    }
    public PersonalityWindow(long id, String name) throws HeadlessException {
        this.name = name;
        initScreen();
    }
    
    public void initScreen() {
        setPreferredSize(size);
        setMinimumSize(size);
        setTitle("Personality");
        
//        setLayout(new FlowLayout());
        GridBagConstraints c = new GridBagConstraints();
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.red);
        
        JTextField nameField = new JTextField(name);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.weightx = 2;
        c.gridx = 0;
        c.gridy = 0;
        
        panel.add(nameField,c);
        
        JButton cancelBtn = new JButton("Cancel");
        c.gridwidth = 2;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(cancelBtn,c);
        
        JButton saveBtn = new JButton("Save");
        c.gridwidth = 2;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 1;
        panel.add(saveBtn,c);
        
        add(panel,BorderLayout.CENTER);
        
    }

}
