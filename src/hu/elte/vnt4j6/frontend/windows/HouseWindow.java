/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.vnt4j6.frontend.windows;

import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author lcsoka
 */
public class HouseWindow extends JFrame {

    private Dimension size = new Dimension(300, 150);
    private String name;
    public HouseWindow() throws HeadlessException {
        initScreen();
    }
    public HouseWindow(long id, String name) throws HeadlessException {
        this.name = name;
        initScreen();
    }
    
    private void initScreen() {
        
    }
    
    public void chooseFile() {
        FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        String file = dialog.getFile();
        System.out.println(file + " chosen.");
    }

}
