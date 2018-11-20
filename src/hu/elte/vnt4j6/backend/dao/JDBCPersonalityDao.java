/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.vnt4j6.backend.dao;

import hu.elte.vnt4j6.backend.entities.House;
import hu.elte.vnt4j6.backend.entities.Personality;
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
public class JDBCPersonalityDao implements PersonalityDao {
    private Connection con;

    public JDBCPersonalityDao(Connection con) {
        this.con = con;
    }

    @Override
    public void delete(Long key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Personality> findAll() {
         
        String sql = "SELECT * FROM progtech2.personality ORDER BY id";

        try (PreparedStatement statement = con.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();) {
            //resultSet feldolgozása
            List<Personality> result = new LinkedList<>();
            while (resultSet.next()) {
                result.add(setPersonality(resultSet));
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCHouseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Personality findById(Long key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Personality save(Personality entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Personality entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCon(Connection con) {
        this.con = con;
    }
    
    /**
     * resultSet alapján egy új Personality objektum létrehozása
     *
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private Personality setPersonality(ResultSet resultSet) throws SQLException {
        Personality personality = new Personality();
        personality.setPersonalityId(resultSet.getInt("id"));
        personality.setPersonalityName(resultSet.getString("name"));
        return personality;
    }
    
}
