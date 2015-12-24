/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.employee;

import userinfo.gui.DialogDepartment;
import userinfo.gui.department.ComboBoxDepartment;

/**
 *
 * @author firsov
 */
public class DepartmentAddButton {

    private final String title = "Новий відділ";
    
    public DepartmentAddButton() {
    }
    
    public void addNewDepartment(ComboBoxDepartment comboBoxDepartment){
        DialogDepartment department = new DialogDepartment(title);
        department.pack();
        department.setLocationRelativeTo(null);
        department.setResizable(false);
        department.setVisible(true);
        comboBoxDepartment.addElement(department.getDepartment());
    }
}
