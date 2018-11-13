/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.vnt4j6.backend.dao;

import hu.elte.vnt4j6.backend.entities.House;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lcsoka
 */
public class JDBCHouseDao implements HouseDao {
    private Connection con;

    public JDBCHouseDao(Connection con) {
        this.con = con;
    }

    @Override
    public int getHouseCount() {
        String sql = "SELECT count(*) as count FROM progtech2.house";

        try (PreparedStatement statement = con.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();) {
            //resultSet feldolgozása
            int count = 0;
            while (resultSet.next()) {
                count = resultSet.getInt("count");
            }
            return count;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCHouseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public void delete(Long key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<House> findAll() {
        
        String sql = "SELECT * FROM progtech2.house";

        try (PreparedStatement statement = con.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();) {
            //resultSet feldolgozása
            List<House> result = new LinkedList<>();
            while (resultSet.next()) {
                result.add(setHouse(resultSet));
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCHouseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public House findById(Long key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public House save(House entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(House entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCon(Connection con) {
        this.con = con;
    }
    
    /**
     * resultSet alapján egy új House objektum létrehozása
     *
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private House setHouse(ResultSet resultSet) throws SQLException {
        House house = new House();
        house.setHouseName(resultSet.getString("name"));
        house.setLogo(resultSet.getString("path"));
        return house;
    }
    
}
