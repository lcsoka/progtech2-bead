/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.vnt4j6.backend.dao;

import hu.elte.vnt4j6.backend.entities.House;
import hu.elte.vnt4j6.backend.entities.Personality;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lcsoka
 */
public class DaoManager {

    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "tanulo";
    private static final String PASSWORD = "NXsn6V*o";

    private Connection con;

    /**
     * A feladatban használt dao osztályok
     */
    private HouseDao hDao;
    private StudentDao sDao;
    private PersonalityDao pDao;
    private CreatureDao cDao;

    public DaoManager() {
        this.hDao = new JDBCHouseDao(con);
        this.pDao = new JDBCPersonalityDao(con);
    }

    public int getHouseCount() {
        open();
        hDao.setCon(con);
        int count = hDao.getHouseCount();
        close();
        return count;
    }

    public List<House> listHouses() {

        open();
        hDao.setCon(con);
        List<House> houses = hDao.findAll();
        close();

        return houses;
    }

    public List<Personality> listPersonalities() {
        open();

        pDao.setCon(con);
        List<Personality> personalities = pDao.findAll();
        close();

        return personalities;
    }

    public void addHouse(House house) {
        open();
        hDao.setCon(con);
        hDao.save(house);
        close();
    }
    
    public void modifyHouse(House house){
        open();
        hDao.setCon(con);
        hDao.update(house);
        close();
    }

    /**
     * Új connection, csatlakozás az adatbázishoz
     */
    private void open() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * connection lezárása
     */
    private void close() {
        try {
            if ((con != null) && !con.isClosed()) {
                con.close();
            }
            System.out.println("Connection closed");
        } catch (SQLException ex) {
            System.err.println("Error closing connection");
            Logger.getLogger(DaoManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getStudentCount(long id) {
        open();
        hDao.setCon(con);
        int count = hDao.getStudentCount(id);
        close();
        return count;
    }
}
