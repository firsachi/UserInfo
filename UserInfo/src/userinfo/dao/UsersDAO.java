/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.dao;

import java.util.ArrayList;
import userinfo.entities.Users;

/**
 *
 * @author firsov
 */
public interface UsersDAO {
    
    Users create(Users users);
    Users find(int idUsers);
    ArrayList<Users> findAll(boolean delete);
    void delete(int idUsers);
    void update(Users users);
    
}
