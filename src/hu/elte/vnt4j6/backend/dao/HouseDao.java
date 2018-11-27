/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.vnt4j6.backend.dao;

import hu.elte.vnt4j6.backend.entities.House;

/**
 *
 * @author lcsoka
 */
public interface HouseDao extends CRUDDao<House, Long> {
    int getHouseCount();
    int getStudentCount(long houseId);
}
