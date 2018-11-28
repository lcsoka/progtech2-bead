/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.vnt4j6.frontend;

import hu.elte.vnt4j6.backend.entities.House;
import hu.elte.vnt4j6.backend.entities.Personality;
import hu.elte.vnt4j6.backend.entities.Student;
import hu.elte.vnt4j6.backend.service.DaoService;
import hu.elte.vnt4j6.backend.service.Service;
import hu.elte.vnt4j6.frontend.windows.MainWindow;
import hu.elte.vnt4j6.frontend.windows.PersonalityWindow;
import java.util.Date;
import java.util.List;

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

    public static int getStudentCount(long id) {
        return service.getStudentCount(id);
    }

    public static void addHouse(String name, String path) {
        service.addHouse(name, path);
    }

    public static void editHouse(String name, String path, long id) {
        service.modifyHouse(name, path, id);
        screen.reloadHousesView();
    }

    public static void addPersonality(String name) {
        service.addPersonality(name);
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

}
