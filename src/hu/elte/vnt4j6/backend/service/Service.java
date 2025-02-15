/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.vnt4j6.backend.service;

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
public interface Service {

    void addCreature(String name, Date firstMet, long personalityId) throws ServiceException;
    void addHouse(String name, String path) throws ServiceException;
    void addPersonality(String name) throws ServiceException;
    void addStudent(String name, long houseId, long personalityId, Date birthday);
    void deleteCreature(long id);
    void deleteHouse(String name);
    void deletePersonality(String name);
    void deleteStudent(long id);
    Creature findCreature(String name);
    Student findStudent(String name);
    List<Creature> listCreatures();
    List<Student> listStudents();
    List<Student> findStudentByName(String name);
    List<House> listHouses();
    List<Personality> listPersonalities();
    void modifyCreature(String name, Date firstMet, long personalityId, long id);
    void modifyHouse(String name, String path, long id);
    void modifyPersonality(String name, long id);
    void modifyStudent(String name, long houseId, long personalityId, Date birthday, long studentId);
    int getHouseCount();
    int getStudentCount(long id);
}
