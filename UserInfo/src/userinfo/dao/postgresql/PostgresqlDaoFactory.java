/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.dao.postgresql;

import userinfo.dao.DaoFactory;
import userinfo.dao.DepartmentDAO;
import userinfo.dao.PostDAO;
import userinfo.dao.UsersDAO;

/**
 *
 * @author firsov
 */
public class PostgresqlDaoFactory extends DaoFactory{

    @Override
    public DepartmentDAO createDepartmentDAO() {
        return new PostgresqlDepartment();
    }

    @Override
    public PostDAO createPostDAO() {
        return new PostgresqlPost();
    }

    @Override
    public UsersDAO createUsersDAO() {
        return new PostgresqlUsers();
    }
    
}
