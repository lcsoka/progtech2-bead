/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.vnt4j6.backend.dao;

import hu.elte.vnt4j6.backend.entities.Personality;
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
public class JDBCStudentDao implements StudentDao {

    private Connection con;

    public JDBCStudentDao(Connection con) {
        this.con = con;
    }

    @Override
    public void delete(Long key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Student> findAll() {

        String sql = "SELECT  student.id, student.name, house.name as house,"
                + "personality.name as personality, student.birthday FROM "
                + "progtech2.student  join progtech2.house, progtech2.personality \n"
                + "where progtech2.student.house_id = progtech2.house.id \n"
                + "and progtech2.student.personality_id = progtech2.personality.id;";

        try (PreparedStatement statement = con.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();) {
            //resultSet feldolgozása
            List<Student> result = new LinkedList<>();
            while (resultSet.next()) {
                result.add(setStudent(resultSet));
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCHouseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Student findById(Long key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student save(Student entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Student entity) {
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
    private Student setStudent(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        student.setHouse(resultSet.getString("house"));
        student.setPersonality(resultSet.getString("personality"));
        student.setBirthday(resultSet.getDate("birthday"));
        return student;
    }
}
