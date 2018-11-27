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
}
