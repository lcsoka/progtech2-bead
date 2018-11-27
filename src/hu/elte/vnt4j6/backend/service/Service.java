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
import java.util.Date;
import java.util.List;

/**
 *
 * @author lcsoka
 */
public interface Service {

    void addCreature(String name, Date firstMet, String personality);
    void addHouse(String name, String path);
    void addPersonality(String name);
    void addStudent(String name, Date birtday, String house, String personality);
    void deleteCreature(long id);
    void deleteHouse(String name);
    void deletePersonality(String name);
    void deleteStudent(long id);
    Creature findCreature(String name);
    Student findStudent(String name);
    List<Creature> listCreatures();
    List<Student> listStudents();
    List<House> listHouses();
    List<Personality> listPersonalities();
    void modifyCreature(Date firstMet);
    void modifyHouse(String name, String path, long id);
    int getHouseCount();
    int getStudentCount(long id);
}
