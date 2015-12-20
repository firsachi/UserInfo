/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.department;

import userinfo.gui.DialogDepartment;

/**
 *
 * @author firsov
 */
public class ActionButtonOkDepartment {

    public ActionButtonOkDepartment() {
    }

    
    public void runAction(DialogDepartment dialogDepartment) {
        switch (dialogDepartment.getAction()){
            case INSERT:
                DeaprtmentAdd deaprtmentAdd = new DeaprtmentAdd();
                deaprtmentAdd.createDepartment(dialogDepartment);
                break;
            case UPDATE:
                DepartmentUpdate departmentUpdate = new DepartmentUpdate();
                departmentUpdate.updateDepartment(dialogDepartment);
                break;
        }
    }
       
}
