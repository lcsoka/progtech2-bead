/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.vnt4j6.frontend.windows;

import hu.elte.vnt4j6.frontend.GuiManager;
import hu.elte.vnt4j6.frontend.components.PersonalitiesPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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

    private Dimension size = new Dimension(300, 100);
    private String name;
    private JTextField nameField;
    private JButton cancelBtn;
    private JButton saveBtn;
    private boolean editing = false;
    private long personalityId;
    public PersonalityWindow() throws HeadlessException {
        initScreen();
    }

    public PersonalityWindow(long id, String name) throws HeadlessException {
        this.personalityId = id;
        this.name = name;
        initScreen();
        nameField.setText(name);
        this.editing = true;
    }

    public void initScreen() {
        setPreferredSize(size);
        setMinimumSize(size);
        setTitle("Personality");
        setLayout(new GridLayout(2, 1));

        nameField = new JTextField("Personality");
        nameField.setForeground(Color.GRAY);
        nameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (nameField.getText().equals("Personality")) {
                    nameField.setText("");
                }
                nameField.setForeground(Color.BLACK);

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (nameField.getText().isEmpty()) {
                    nameField.setForeground(Color.GRAY);
                    nameField.setText("Personality");
                }
            }

        });

        add(nameField);
        JPanel panel = new JPanel(new GridLayout(1, 2));
        cancelBtn = new JButton("Cancel");
        saveBtn = new JButton("Save");
        panel.add(cancelBtn);
        panel.add(saveBtn);

        add(panel);
        initButtons();
    }

    public void initButtons() {
        cancelBtn.addActionListener(this::closeWindow);
        saveBtn.addActionListener(this::savePersonality);
    }

    public void closeWindow(ActionEvent e) {
        setVisible(false);
        dispose();
    }

    public void savePersonality(ActionEvent e) {

        // TODO: Validation here...
        if (editing) {
            GuiManager.editPersonality(nameField.getText(), personalityId);
        } else {
            GuiManager.addPersonality(nameField.getText());
        }

        this.closeWindow(e);
    }

}
