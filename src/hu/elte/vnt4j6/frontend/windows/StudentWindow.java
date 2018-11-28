/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.vnt4j6.frontend.windows;

import hu.elte.vnt4j6.backend.entities.House;
import hu.elte.vnt4j6.backend.entities.Personality;
import hu.elte.vnt4j6.frontend.GuiManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Stream;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.SqlDateModel;

/**
 *
 * @author lcsoka
 */
public class StudentWindow extends JFrame {

    private Dimension size = new Dimension(300, 200);
    private JTextField nameField;
    private JComboBox houseComboBox;
    private JComboBox personalitiesComboBox;
    private JDatePicker birthdayPicker;
    private JButton cancelBtn;
    private JButton saveBtn;
    private long studentId;
    private String studentName;

    private List<House> houseList;
    private List<Personality> personalityList;
    private boolean editing = false;

    public StudentWindow() throws HeadlessException {
        loadData();
        initScreen();
    }

    public StudentWindow(long id, String name, String house, String personality, Date birthday) throws HeadlessException {
        this.studentId = id;
        this.studentName = name;
        loadData();
        initScreen();
        nameField.setText(name);
        int houseIndex = 0;
        for (House currentHouse : houseList) {
            if(currentHouse.getHouseName().equals(house)){
                houseIndex = houseList.indexOf(currentHouse);
            }
        }
        
        this.houseComboBox.setSelectedIndex(houseIndex);
        
        int personalityIndex = 0;
        for (Personality currentPersonality : personalityList) {
            if(currentPersonality.getPersonalityName().equals(personality)){
                personalityIndex = personalityList.indexOf(currentPersonality);
            }
        }
        
        this.personalitiesComboBox.setSelectedIndex(personalityIndex);
        
        System.out.println(birthday);
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthday);
        
        this.birthdayPicker.getModel().setYear(calendar.get(Calendar.YEAR));
        this.birthdayPicker.getModel().setMonth(calendar.get(Calendar.MONTH));
        this.birthdayPicker.getModel().setDay(calendar.get(Calendar.DAY_OF_MONTH));
        this.birthdayPicker.getModel().setSelected(true);
        
        
        this.editing = true;
    }

    private void loadData() {
        this.houseList = GuiManager.listAllHouses();
        this.personalityList = GuiManager.listAllPersonalities();
    }

    public void initScreen() {
        setPreferredSize(size);
        setMinimumSize(size);
        setTitle("Student");
        setLayout(new GridLayout(5, 1));

        nameField = new JTextField("Name");
        nameField.setForeground(Color.GRAY);
        nameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (nameField.getText().equals("Name")) {
                    nameField.setText("");
                }
                nameField.setForeground(Color.BLACK);

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (nameField.getText().isEmpty()) {
                    nameField.setForeground(Color.GRAY);
                    nameField.setText("Name");
                }
            }

        });

        houseComboBox = new JComboBox(houseList.toArray());
//        houseComboBox.addItemListener((e) -> {
//            System.out.println(houseComboBox.getSelectedItem());
//        });
        personalitiesComboBox = new JComboBox(personalityList.toArray());

        birthdayPicker = new JDatePicker();
        
        birthdayPicker.addActionListener((e) -> {
            System.out.println(e);
        });
        add(nameField);
        add(houseComboBox);
        add(personalitiesComboBox);
        add(birthdayPicker);

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
        saveBtn.addActionListener(this::saveStudent);
    }

    public void closeWindow(ActionEvent e) {
        setVisible(false);
        dispose();
    }

    public void saveStudent(ActionEvent e) {

        // TODO: Validation here...
        
            Calendar cal = (GregorianCalendar)birthdayPicker.getModel().getValue();
        if (editing) {

            GuiManager.editStudent(
                    nameField.getText(),
                    (House) houseComboBox.getSelectedItem(),
                    (Personality) personalitiesComboBox.getSelectedItem(),
                    cal.getTime(),
                    studentId
            );
        } else {
            GuiManager.addStudent(
                    nameField.getText(),
                    (House) houseComboBox.getSelectedItem(),
                    (Personality) personalitiesComboBox.getSelectedItem(),
                    cal.getTime()
            );
        }

        this.closeWindow(e);
    }

}
