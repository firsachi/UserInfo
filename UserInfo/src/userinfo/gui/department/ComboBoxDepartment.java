/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.department;

import java.util.ArrayList;
import javax.swing.JComboBox;
import userinfo.dao.DaoFactory;
import userinfo.dao.DepartmentDAO;
import userinfo.entities.Department;

/**
 *
 * @author firsov
 */
public class ComboBoxDepartment extends JComboBox<Object>{
    
    private final ArrayList<Department> arrayListDeaprtment;

    public ComboBoxDepartment() {
        DaoFactory daoFactory = DaoFactory.getInstance(DaoFactory.DaoType.POSTGRESQL);
        DepartmentDAO departmentDAO = daoFactory.createDepartmentDAO();
        arrayListDeaprtment = departmentDAO.findAll(false);
        createCombobox();
    }

    private void createCombobox() {
        for (Department department : arrayListDeaprtment){
            addItem(department);
        }
    }
    
    public void addElement(Department department){
        if (department.getUpdate()){
            arrayListDeaprtment.add(department);
            addItem(department);
            setSelectedItem(department.getDepartmentName());
        }
    }
    
    private void addItem(Department department){
        addItem(department.getDepartmentName());
    }
    
}
