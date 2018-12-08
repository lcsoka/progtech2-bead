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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lcsoka
 */
public class DaoServiceTest {

    static DaoService instance;
    static List<House> houses;
    static List<Creature> creatures;
    static List<Personality> personalities;
    
    public DaoServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        instance = new DaoService();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addCreature method, of class DaoService.
     */
    @Test
    public void testAddCreature() throws ServiceException {
        System.out.println("addCreature");
        String name = "Test Creature";
        Date firstMet = null;
        long personalityId = 0L;
        instance.addCreature(name, firstMet, personalityId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addHouse method, of class DaoService.
     */
    @Test
    public void testAddHouse() throws Exception {
        System.out.println("addHouse");
        String name = "";
        String path = "";
        instance.addHouse(name, path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPersonality method, of class DaoService.
     */
    @Test
    public void testAddPersonality() throws Exception {
        System.out.println("addPersonality");
        String name = "";
        instance.addPersonality(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
