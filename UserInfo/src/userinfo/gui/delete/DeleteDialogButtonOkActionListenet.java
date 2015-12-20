/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.delete;

import userinfo.gui.department.DepartmentDelete;
import java.awt.event.ActionEvent;
import userinfo.gui.DeleteInfoDialog;

/**
 *
 * @author firsov
 */
public class DeleteDialogButtonOkActionListenet implements DeleteRow{
    
    private DeleteInfoDialog deleteInfoDialog;
    
    public DeleteDialogButtonOkActionListenet() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DepartmentDelete departmentDelete = new DepartmentDelete();
        departmentDelete.deleteDepartment(deleteInfoDialog);
    }

    @Override
    public void setDeleteInfoDialog(DeleteInfoDialog deleteInfoDialog) {
        this.deleteInfoDialog = deleteInfoDialog;
    }
    
}
