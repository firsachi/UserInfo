/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author firsov
 */
class DeleteDialogButtonOkActionListenet implements ActionListener {
    
    private final DeleteInfoDialog deleteInfoDialog;
    
    public DeleteDialogButtonOkActionListenet(DeleteInfoDialog deleteInfoDialog1) {
        this.deleteInfoDialog = deleteInfoDialog1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DepartmentDelete departmentDelete = new DepartmentDelete();
        departmentDelete.deleteDepartment(deleteInfoDialog);
    }
    
}
