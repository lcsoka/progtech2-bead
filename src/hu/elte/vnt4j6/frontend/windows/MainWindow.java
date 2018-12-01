/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.vnt4j6.frontend.windows;

import hu.elte.vnt4j6.backend.entities.Creature;
import hu.elte.vnt4j6.backend.entities.House;
import hu.elte.vnt4j6.backend.entities.Personality;
import hu.elte.vnt4j6.backend.entities.Student;
import hu.elte.vnt4j6.frontend.GuiManager;
import hu.elte.vnt4j6.frontend.components.CreaturesPanel;
import hu.elte.vnt4j6.frontend.components.HousesPanel;
import hu.elte.vnt4j6.frontend.components.PersonalitiesPanel;
import hu.elte.vnt4j6.frontend.components.StudentsPanel;
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
    private static StudentsPanel studentsPanel;
    private static CreaturesPanel creaturesPanel;
    private static JTabbedPane tabs;
    private Dimension size = new Dimension(600, 450);
//    private static HousesPanel contentPanel;
    
    private final static Object[] PERSONALITY_COLUMN_NAMES = new Object[]{"id", "Name"};
    private final static Object[] STUDENTS_COLUMN_NAMES = new Object[]{"id", "Name", "House", "Personality", "Birthday"};
    private final static Object[] CREATURES_COLUMN_NAMES = new Object[]{"id", "Name", "First Met", "Personality"};

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
        studentsPanel = new StudentsPanel(this);
        creaturesPanel = new CreaturesPanel(this);
        
        tabs.addTab("Houses", housesPanel);
        tabs.setSelectedIndex(0);
        tabs.addTab("Students", studentsPanel);
        tabs.addTab("Creatures", creaturesPanel);
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
        List<House> houses = GuiManager.listAllHouses();
        housesPanel.setHouses(houses);
        
        reloadStudentsView();
        reloadPersonalitiesView();
        reloadCreaturesPanel();
        
        
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
    
    public void reloadHousesView(){
        List<House> houses = GuiManager.listAllHouses();
        housesPanel.setHouses(houses);
    }
    
    public void reloadStudentsView() {
        List<Student> students = GuiManager.listAllStudents();
        List<Object> student_content = new ArrayList<>();
        students.forEach(row -> student_content.add(row.toArray()));
        studentsPanel.addContentToTable(student_content, STUDENTS_COLUMN_NAMES);
    }
  
    public void reloadStudentsView(List<Student> students) {
        List<Object> student_content = new ArrayList<>();
        students.forEach(row -> student_content.add(row.toArray()));
        studentsPanel.addContentToTable(student_content, STUDENTS_COLUMN_NAMES);
    }
  
        
    public void reloadCreaturesPanel(){
        List<Creature> creatures = GuiManager.listAllCreatures();
        List<Object> content = new ArrayList<>();
        creatures.forEach(row -> content.add(row.toArray()));
        creaturesPanel.addContentToTable(content, CREATURES_COLUMN_NAMES);
    }
    
    
    public void reloadPersonalitiesView(){
        List<Personality> personalities = GuiManager.listAllPersonalities();
        List<Object> content = new ArrayList<>();
        personalities.forEach(row -> content.add(row.toArray()));
        personalitiesPanel.addContentToTable(content, PERSONALITY_COLUMN_NAMES);
    }
    
}
