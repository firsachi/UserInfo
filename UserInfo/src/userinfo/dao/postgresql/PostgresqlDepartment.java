/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.dao.postgresql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import userinfo.dao.DepartmentDAO;
import userinfo.databases.ReceiveConnect;
import userinfo.entities.Department;

/**
 *
 * @author firsov
 */
public class PostgresqlDepartment implements DepartmentDAO{

    private Department department;
    
    @Override
    public Department create(Department department) {
        String query ="INSERT INTO department (name_department) VALUES (?)";
        try (PreparedStatement preparedStatement = ReceiveConnect.getConnectionDatabase().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);)   
        {
            preparedStatement.setString(1, department.getDepartmentName());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next() ){
                department.setIdDepartment(resultSet.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlDepartment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return department;
    }

    @Override
    public Department find(int idDepartment) {
        String query = "SELECT * FROM department WHERE id_department=?";
        try(PreparedStatement preparedStatement = ReceiveConnect.getConnectionDatabase().prepareStatement(query);)
        {   
            preparedStatement.setInt(1, idDepartment);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                department = createNewDeaprtment(resultSet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlDepartment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  department;
    }

    @Override
    public ArrayList<Department> findAll(boolean delte) {
         ArrayList<Department> arrayListResult = new ArrayList<>();
        String query = "SELECT id_department,name_department FROM department WHERE delete_department=? ORDER BY id_department;";
        try (PreparedStatement preparedStatement = ReceiveConnect.getConnectionDatabase().prepareStatement(query);)
        {
            preparedStatement.setBoolean(1, delte);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                   arrayListResult.add(createNewDeaprtment(resultSet));
            } 
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlDepartment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayListResult;
    }

    @Override
    public boolean delete(int idDepartment) {
        boolean result = false;
        String query = "UPDATE department SET delete_department=true WHERE id_department=? AND 0=(SELECT COUNT(*) FROM users WHERE id_department=?)";
        try (
                PreparedStatement preparedStatement = ReceiveConnect.getConnectionDatabase().prepareStatement(query);
                )
        {
            preparedStatement.setInt(1, idDepartment);
            preparedStatement.setInt(2, idDepartment);
            int res = preparedStatement.executeUpdate();
            System.err.println(res);
            if(0 == res){
                result = true;
                return result;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlDepartment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean update(Department department) {
        boolean result = false;
        String query ="UPDATE department SET name_department=? WHERE id_department=? AND delete_department=false AND 0=(SELECT COUNT(*) FROM department WHERE id_department!=? AND name_department=? AND delete_department=false )";
        try (PreparedStatement preparedStatement = ReceiveConnect.getConnectionDatabase().prepareStatement(query);)
        {
            preparedStatement.setString(1, department.getDepartmentName());
            preparedStatement.setInt(2, department.getIdDepartment());
            preparedStatement.setInt(3, department.getIdDepartment());
            preparedStatement.setString(4, department.getDepartmentName());
            int res = preparedStatement.executeUpdate();
            if (0 < res){
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlDepartment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean findName(Department department){
        String query = "SELECT COUNT(*) FROM department WHERE name_department=? AND delete_department=false";
        boolean resultFind = true;
        try (PreparedStatement preparedStatement = ReceiveConnect.getConnectionDatabase().prepareStatement(query);) 
        {
            preparedStatement.setString(1, department.getDepartmentName());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next() && resultSet.getInt(1)>0){
                resultFind = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlDepartment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultFind;
    }
    
    private Department createNewDeaprtment(ResultSet resultSet) {
        department = new Department();
        try {
            department.setIdDepartment(resultSet.getInt(1));
            department.setDepartmentName(resultSet.getString(2));
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlDepartment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  department;
    }
}
