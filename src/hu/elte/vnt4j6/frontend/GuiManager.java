/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.vnt4j6.frontend;

import hu.elte.vnt4j6.backend.entities.Creature;
import hu.elte.vnt4j6.backend.entities.House;
import hu.elte.vnt4j6.backend.entities.Personality;
import hu.elte.vnt4j6.backend.entities.Student;
import hu.elte.vnt4j6.backend.service.DaoService;
import hu.elte.vnt4j6.backend.service.Service;
import hu.elte.vnt4j6.backend.service.exceptions.ServiceException;
import hu.elte.vnt4j6.frontend.windows.MainWindow;
import hu.elte.vnt4j6.frontend.windows.PersonalityWindow;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lcsoka
 */
public class GuiManager {

    private static MainWindow screen;
    private static final Service service = new DaoService();

    public static void start() {
        screen = new MainWindow();
        screen.pack();
        screen.setVisible(true);
    }

    public static List<House> listAllHouses() {
        return service.listHouses();
    }

    public static List<Student> listAllStudents() {
        return service.listStudents();
    }

    public static List<Personality> listAllPersonalities() {
        return service.listPersonalities();
    }

    public static List<Creature> listAllCreatures() {
        return service.listCreatures();
    }

    public static int getStudentCount(long id) {
        return service.getStudentCount(id);
    }

    public static void addHouse(String name, String path) {
        try {
            service.addHouse(name, path);
            screen.reloadHousesView();
        } catch (ServiceException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }

    public static void editHouse(String name, String path, long id) {
        service.modifyHouse(name, path, id);
        screen.reloadHousesView();
        screen.reloadStudentsView();
    }

    public static void addPersonality(String name) {
        try {
            service.addPersonality(name);
            screen.reloadPersonalitiesView();
        } catch (ServiceException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }

    public static void editPersonality(String name, long id) {
        service.modifyPersonality(name, id);
        screen.reloadPersonalitiesView();
    }

    public static void addStudent(String name, House house, Personality personality, Date birthday) {
        System.out.println("Adding student");
        service.addStudent(name, house.getId(), personality.getPersonalityId(), birthday);
        screen.reloadStudentsView();
    }

    public static void editStudent(String name, House house, Personality personality, Date birthday, long id) {
        service.modifyStudent(name, house.getId(), personality.getPersonalityId(), birthday, id);
        screen.reloadStudentsView();
    }

    public static void refreshStudentList() {
        screen.reloadStudentsView();
    }

    public static List<Student> findStudentByName(String name) {
        List<Student> students = service.findStudentByName(name);
        screen.reloadStudentsView(students);
        return students;
    }

    public static void addCreature(String name, Personality personality, Date firstMet) {
        System.out.println("Adding creature");
        try {
            service.addCreature(name, firstMet, personality.getPersonalityId());
            screen.reloadCreaturesPanel();
        } catch (ServiceException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }

    public static void editCreature(String name, Personality personality, Date firstMet, long id) {
        service.modifyCreature(name, firstMet, personality.getPersonalityId(), id);
        screen.reloadCreaturesPanel();
    }
}
