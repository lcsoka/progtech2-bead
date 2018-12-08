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
import java.sql.Statement;
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
        String sql = "INSERT INTO progtech2.creature (name, personality_id, first_met) VALUES (?, ?, ?)";

        try (PreparedStatement statement = createPreparedStatementForSave(con, sql, entity);
                ResultSet generatedKeys = statement.getGeneratedKeys();) {

            if (generatedKeys.next()) {
                entity.setId(generatedKeys.getLong(1));
                return entity;
            } else {
                throw new SQLException("failed order creation");
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCCreatureDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


     @Override
    public void update(Creature entity) {
         String sql = "UPDATE progtech2.creature SET name=?, first_met=?, personality_id=? WHERE id=?";
        try (PreparedStatement statement = createPreparedStatementForUpdate(con, sql, entity);) {
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCCreatureDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setCon(Connection con) {
        this.con = con;
    }

    private PreparedStatement createPreparedStatementForSave(Connection con, String sql, Creature entity) throws SQLException {
        //Statement.RETURN_GENERATED_KEYS => beállítjuk, hogy a generált kulcs visszakérhető legyen
        PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, entity.getName());
        statement.setLong(2, entity.getPersonalityId());
        statement.setDate(3, new java.sql.Date(entity.getFirstMetDate().getTime()));

        statement.executeUpdate();

        return statement;
    }
    
     private PreparedStatement createPreparedStatementForUpdate(Connection con, String sql, Creature entity) throws SQLException {
        PreparedStatement statement = con.prepareStatement(sql);

        statement.setString(1, entity.getName());
        statement.setDate(2, new java.sql.Date(entity.getFirstMetDate().getTime()));
        statement.setLong(3, entity.getPersonalityId());
        statement.setLong(4, entity.getId());

        return statement;
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
