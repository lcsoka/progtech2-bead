/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.vnt4j6.frontend.components;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author lcsoka
 */
public class ImageView extends Canvas {

    private String file;

    public ImageView(String file) {
        this.file = file;
    }
    
    public void paint(Graphics g) {
        System.out.println("PAINT");
        Toolkit t = Toolkit.getDefaultToolkit();
        Image i = t.getImage(file);
        g.drawImage(i, 120, 100, this);
    }

}
