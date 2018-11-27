/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.vnt4j6.frontend.windows;

import hu.elte.vnt4j6.backend.entities.House;
import hu.elte.vnt4j6.frontend.GuiManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author lcsoka
 */
public class HouseWindow extends JFrame {

    private Dimension size = new Dimension(300, 150);
    private String name;
    private String path;
    private JTextField houseName;
    private JTextField filePath;
    private JButton browseBtn;
    private JButton saveBtn;
    private JButton cancelBtn;
    private boolean editing = false;
    private long houseId;

    public HouseWindow() throws HeadlessException {
        initScreen();
    }

    public HouseWindow(House house) throws HeadlessException {
        this.name = house.getHouseName();
        this.path = house.getLogo();
        this.houseId = house.getId();
        initScreen();
        houseName.setText(this.name);
        filePath.setText(this.path);
        editing = true;
    }

    private void initScreen() {
        setPreferredSize(size);
        setMinimumSize(size);
        setTitle("House");
        setLayout(new GridLayout(4, 1));

        houseName = new JTextField("Name");
        houseName.setForeground(Color.GRAY);
        houseName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (houseName.getText().equals("Name")) {
                    houseName.setText("");
                }
                houseName.setForeground(Color.BLACK);

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (houseName.getText().isEmpty()) {
                    houseName.setForeground(Color.GRAY);
                    houseName.setText("Name");
                }
            }
        });

        add(houseName);

        filePath = new JTextField("File path");
        filePath.setEnabled(false);
        add(filePath);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        browseBtn = new JButton("Browse");
        cancelBtn = new JButton("Cancel");
        panel.add(browseBtn);
        panel.add(cancelBtn);

        add(panel);
        saveBtn = new JButton("Save");
        add(saveBtn);
        initButtons();
    }

    public void initButtons() {
        cancelBtn.addActionListener(this::closeWindow);
        browseBtn.addActionListener(this::chooseFile);
        saveBtn.addActionListener(this::saveHouse);
    }

    public void closeWindow(ActionEvent e) {
        setVisible(false);
        dispose();
    }

    public void chooseFile(ActionEvent e) {
        FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        String file = dialog.getDirectory() + dialog.getFile();
        filePath.setText(file);
    }

    public void saveHouse(ActionEvent e) {
        
        // TODO: Validation here...
        
        if (editing) {
            GuiManager.editHouse(houseName.getText(), filePath.getText(), houseId);
        } else {
            GuiManager.addHouse(houseName.getText(), filePath.getText());
        }
        
        this.closeWindow(e);
    }

}
