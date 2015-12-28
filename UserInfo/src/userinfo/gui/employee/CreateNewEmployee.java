/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.employee;

import userinfo.dao.DaoFactory;
import userinfo.dao.UsersDAO;
import userinfo.entities.Users;
import userinfo.gui.Employee;

/**
 *
 * @author firsov
 */
class CreateNewEmployee {

    private final Employee employee;
    
    public CreateNewEmployee(Employee employee) {
        this.employee=employee;
    }
    
    public Users createNewUser(){
        DaoFactory daoFactory = DaoFactory.getInstance(DaoFactory.DaoType.POSTGRESQL);
        UsersDAO usersDAO = daoFactory.createUsersDAO();
    }
}
