/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.dao;

import java.util.ArrayList;
import userinfo.entities.Department;

/**
 *
 * @author firsov
 */
public interface DepartmentDAO {
    
    Department create(Department department);
    Department find(int idDepartment);
    ArrayList<Department> findAll(boolean delete);
    boolean delete(int idDepartment);
    boolean update(Department department);
    public boolean findName(Department department);
}
