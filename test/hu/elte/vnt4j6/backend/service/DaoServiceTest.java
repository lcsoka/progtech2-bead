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
import org.junit.Rule;
import org.junit.rules.ExpectedException;

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

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    
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

    @Test
    public void testAddHouse() throws Exception {
        System.out.println("addExistingHouse");
        String name = "Gryffindor";
        String path = "";
        exception.expect(ServiceException.class);
        instance.addHouse(name, path);
    }
    
    @Test
    public void testAddExistingPersonality() throws ServiceException {
        System.out.println("addExistingPersonality");
        String name = "mad";
        
        exception.expect(ServiceException.class);
        instance.addPersonality(name);
    }

}
