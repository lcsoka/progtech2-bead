/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.vnt4j6.backend.dao;

import hu.elte.vnt4j6.backend.entities.Creature;
import hu.elte.vnt4j6.backend.entities.Student;
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
public class JDBCCreatureDao implements CreatureDao {

    private Connection con;

    public JDBCCreatureDao(Connection con) {
        this.con = con;
    }

    @Override
    public void delete(Long key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Creature> findAll() {
        String sql = "SELECT creature.id, creature.name, creature.first_met, "
                + "creature.personality_id, personality.name AS personality_name"
                + " FROM progtech2.creature JOIN progtech2.personality ON "
                + "creature.personality_id = personality.id;";
        try (PreparedStatement statement = con.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();) {
            //resultSet feldolgozása
            List<Creature> result = new LinkedList<>();
            while (resultSet.next()) {
                result.add(setCreature(resultSet));
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCCreatureDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Creature findById(Long key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Creature save(Creature entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Creature entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * resultSet alapján egy új Student objektum létrehozása
     *
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private Creature setCreature(ResultSet resultSet) throws SQLException {
        Creature creature = new Creature();
        creature.setId(resultSet.getInt("id"));
        creature.setName(resultSet.getString("name"));
        creature.setPersonality(resultSet.getString("personality_name"));
        creature.setFirstMetDate(resultSet.getDate("first_met"));
        return creature;
    }

}
