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
import hu.elte.vnt4j6.backend.service.exceptions.ServiceException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author lcsoka
 */
public class DaoService implements Service {

    private DaoManager dm = new DaoManager();

    @Override
    public void addCreature(String name, Date firstMet, long personalityId) throws ServiceException {

        List<Creature> creatures = dm.listCreatures();
        boolean hasSameName = false;
        for (Creature creature : creatures) {
            if (creature.getName().equals(name)) {
                hasSameName = true;
            }
        }

        if (!hasSameName) {
            Creature creature = new Creature();
            creature.setName(name);
            creature.setFirstMetDate(firstMet);
            creature.setPersonalityId(personalityId);
            dm.addCreature(creature);
        } else {
            throw new ServiceException("A creature already exists with this name!");
        }

    }

    @Override
    public void addHouse(String name, String path) throws ServiceException {
        List<House> houses = dm.listHouses();
        boolean hasSameName = false;

        for (House house : houses) {
            if (house.getHouseName().equals(name)) {
                hasSameName = true;
            }
        }
        if (!hasSameName) {
            House house = new House();
            house.setHouseName(name);
            house.setLogo(path);
            dm.addHouse(house);
        } else {
            throw new ServiceException("A house already exists with this name!");
        }
    }

    @Override
    public void addPersonality(String name) throws ServiceException {

        List<Personality> personalities = dm.listPersonalities();
        boolean hasSameName = false;

        for (Personality personality : personalities) {
            if (personality.getPersonalityName().equals(name)) {
                hasSameName = true;
            }
        }

        if (!hasSameName) {
            Personality personality = new Personality();
            personality.setPersonalityName(name);
            dm.addPersonality(personality);
        } else {
            throw new ServiceException("A personality already exists with this name!");
        }
    }

    @Override
    public void addStudent(String name, long houseId, long personalityId, Date birthday) {
        Student student = new Student();
        student.setName(name);
        student.setHouseId(houseId);
        student.setPersonalityId(personalityId);
        student.setBirthday(birthday);
        dm.addStudent(student);
    }

    @Override
    public void modifyStudent(String name, long houseId, long personalityId, Date birthday, long studentId) {
        Student student = new Student();
        student.setName(name);
        student.setHouseId(houseId);
        student.setPersonalityId(personalityId);
        student.setBirthday(birthday);
        student.setId(studentId);
        dm.modifyStudent(student);
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
        return dm.listCreatures();
    }

    @Override
    public List<Student> listStudents() {
        return dm.listStudents();
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
    public void modifyCreature(String name, Date firstMet, long personalityId, long id) {
        Creature creature = new Creature();
        creature.setName(name);
        creature.setFirstMetDate(firstMet);
        creature.setPersonalityId(personalityId);
        creature.setId(id);
        dm.modifyCreature(creature);
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

    @Override
    public void modifyPersonality(String name, long id) {
        Personality personality = new Personality();
        personality.setPersonalityId(id);
        personality.setPersonalityName(name);
        dm.modifyPersonality(personality);
    }

    @Override
    public List<Student> findStudentByName(String name) {
        return dm.findStudentByName(name);
    }

}
