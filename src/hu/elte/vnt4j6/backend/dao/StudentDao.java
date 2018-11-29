/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.vnt4j6.backend.dao;

import hu.elte.vnt4j6.backend.entities.Student;
import java.util.List;

/**
 *
 * @author lcsoka
 */
public interface StudentDao extends CRUDDao<Student, Long> {
    List<Student> findByName(String name);
}
