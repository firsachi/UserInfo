/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.entities;

/**
 *
 * @author firsov
 */
public interface RowEntities {
    
    void setUpdate(boolean update);
    boolean getUpdate();
    Object[] getRow();
}
