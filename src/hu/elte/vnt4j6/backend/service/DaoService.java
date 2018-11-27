/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.vnt4j6.backend.service;

import hu.elte.vnt4j6.backend.dao.DaoManager;
import hu.elte.vnt4j6.backend.entities.Creature;
import hu.elte.vnt4j6.backend.entities.House;
import hu.elte.vnt4j6.backend.entities.Personality;
import hu.elte.vnt4j6.backend.entities.Student;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lcsoka
 */
public class DaoService implements Service {

 
    private DaoManager dm = new DaoManager();

    @Override
    public void addCreature(String name, Date firstMet, String personality) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addHouse(String name, String path) {
        House house = new House();
        house.setHouseName(name);
        house.setLogo(path);
        dm.addHouse(house);
    }

    @Override
    public void addPersonality(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addStudent(String name, Date birtday, String house, String personality) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCreature(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteHouse(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePersonality(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteStudent(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Creature findCreature(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student findStudent(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Creature> listCreatures() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Student> listStudents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<House> listHouses() {
        return dm.listHouses();
    }

    @Override
    public List<Personality> listPersonalities() {
        return dm.listPersonalities();
    }

    @Override
    public void modifyCreature(Date firstMet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int getHouseCount() {
        return dm.getHouseCount();
    }

    @Override
    public int getStudentCount(long id) {
        return dm.getStudentCount(id);
    }

    @Override
    public void modifyHouse(String name, String path, long id) {
        House house = new House();
        house.setHouseName(name);
        house.setLogo(path);
        house.setId(id);
        dm.modifyHouse(house);
    }
    
    
    
    
}
