/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author firsov
 */
public abstract class DaoFactory {
    
    public abstract DepartmentDAO createDepartmentDAO();
    public abstract PostDAO createPostDAO();
    public abstract UsersDAO createUsersDAO();
    
    public enum DaoType{POSTGRESQL, STUB}
    
    public static DaoFactory getInstance( DaoType type ){
        switch (type){
            case POSTGRESQL: 
                try {
                    Class classPostgresql = Class.forName("userinfo.dao.postgresql.PostgresqlDaoFactory");           
                    return (DaoFactory) classPostgresql.newInstance();
                } catch (ClassNotFoundException |InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(DaoFactory.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        }
        return null;
    }
}
