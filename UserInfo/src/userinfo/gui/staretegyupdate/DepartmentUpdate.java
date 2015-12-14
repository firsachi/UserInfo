/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.staretegyupdate;

import userinfo.entities.Department;
import userinfo.entities.RowEntities;
import userinfo.gui.DialogDepartment;

/**
 *
 * @author firsov
 */
class DepartmentUpdate implements ButtonUpdateStarategy{
    
    private final String title = "Змінити назву відділу.";    
    @Override
    public RowEntities getUpdateRow(Department department) {
        DialogDepartment dialogDepartment = new DialogDepartment(title);
        //dialogDepartment.setTitle(title);
        dialogDepartment.setDepartment(department);
        dialogDepartment.pack();
        dialogDepartment.setLocationRelativeTo(null);
        dialogDepartment.setResizable(false);
        dialogDepartment.setVisible(true);
        return dialogDepartment.getDepartment();
    }
    
}
