/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.dao.postgresql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import userinfo.dao.UsersDAO;
import userinfo.databases.ReceiveConnect;
import userinfo.entities.Users;

/**
 *
 * @author firsov
 */
public class PostgresqlUsers implements UsersDAO{

    @Override
    public Users create(Users users) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Users find(int idUsers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Users> findAll(boolean delete) {
        ArrayList<Users> arrayListUsers = new ArrayList<>();
        String query = "SELECT id_users,name_users,surname_users,patronymic_users,login_users,password_users,email_users,name_department,name_post,access_users FROM users JOIN department ON (users.id_department=department.id_department) JOIN post ON (users.id_post=post.id_post) WHERE delete_users=?";
        try (PreparedStatement preparedStatement = ReceiveConnect.getConnectionDatabase().prepareStatement(query);)
        {
            preparedStatement.setBoolean(1, delete);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                arrayListUsers.add(createUsers(resultSet));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayListUsers;
    }

    @Override
    public void delete(int idUsers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Users users) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Users createUsers(ResultSet resultSet) {
        Users users = new Users();
        try {
            users.setIdUsers(resultSet.getInt(1));
            users.setNameUsers(resultSet.getString(2));
            users.setSurnameUser(resultSet.getString(3));
            users.setPatronymicUsers(resultSet.getString(4));
            users.setLoginUsers(resultSet.getString(5));
            users.setPaswordUsers(resultSet.getString(6));
            users.setEmailUsers(resultSet.getString(7));
            users.setDepartmentUsers(resultSet.getString(8));
            users.setPostUsers(resultSet.getString(9));
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
}
