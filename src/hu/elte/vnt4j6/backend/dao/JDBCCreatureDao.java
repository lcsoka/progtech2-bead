/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.vnt4j6.backend.dao;

import hu.elte.vnt4j6.backend.entities.Creature;
import java.sql.Connection;
import java.util.List;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}
