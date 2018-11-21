/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.vnt4j6.frontend.windows;

import hu.elte.vnt4j6.backend.entities.Personality;
import hu.elte.vnt4j6.frontend.GuiManager;
import hu.elte.vnt4j6.frontend.components.HousesPanel;
import hu.elte.vnt4j6.frontend.components.PersonalitiesPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author lcsoka
 */
public class MainWindow extends JFrame {

    private static JPanel actionPanel;
    private static HousesPanel housesPanel;
    private static PersonalitiesPanel personalitiesPanel;
    private static JTabbedPane tabs;
    private Dimension size = new Dimension(600, 450);
//    private static HousesPanel contentPanel;
    
    private final static Object[] PERSONALITY_COLUMN_NAMES = new Object[]{"id", "Name"};

    public MainWindow() throws HeadlessException {
        initScreen();
    }

    private void initScreen() {
        setLayout(new FlowLayout());
//        contentPanel = new HousesPanel(this);
        actionPanel = new JPanel();
        tabs = new JTabbedPane();
       
        housesPanel = new HousesPanel(this);
        personalitiesPanel = new PersonalitiesPanel(this);
        
        tabs.addTab("Houses", housesPanel);
        tabs.setSelectedIndex(0);
        JPanel jplInnerPanel2 = createInnerPanel("Tab 2 Contains Icon only");
        tabs.addTab("Students", jplInnerPanel2);
        JPanel jplInnerPanel3 = createInnerPanel("Tab 3 Contains Tooltip and Icon");
        tabs.addTab("Creatures", jplInnerPanel3);
        JPanel jplInnerPanel4 = createInnerPanel("Tab 4 Contains Text only");
        tabs.addTab("Personalities", personalitiesPanel);
        // Add the tabbed pane to this panel.
        actionPanel.setLayout(new GridLayout(1, 1));
        add(tabs);

        actionPanel.add(tabs);

        add(actionPanel);
        setSize(size);
        setPreferredSize(size);
        setMinimumSize(size);
        setTitle("Beadando");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridLayout(1, 1));
        
        // Load Data
        List<Personality> personalities = GuiManager.listAllPersonalities();
        List<Object> content = new ArrayList<>();
        personalities.forEach(row -> content.add(row.toArray()));
        personalitiesPanel.addContentToTable(content, PERSONALITY_COLUMN_NAMES);
        
        
    }

    protected JPanel createInnerPanel(String text) {
        JPanel jplPanel = new JPanel();
        JLabel jlbDisplay = new JLabel(text);
        jlbDisplay.setHorizontalAlignment(JLabel.CENTER);
        jplPanel.setLayout(new GridLayout(1, 1));
        jplPanel.add(jlbDisplay);
        return jplPanel;
    }
    
    public void addHouse(){
        System.out.println("Opening add house window...");
    }
  
    
}
