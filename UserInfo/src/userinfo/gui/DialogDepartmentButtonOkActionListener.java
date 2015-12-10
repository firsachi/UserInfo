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
class DialogDepartmentButtonOkActionListener implements ActionListener {

    private final DialogDepartment dialogDepartment;
    
    public DialogDepartmentButtonOkActionListener(DialogDepartment dialogDepartment) {
        this.dialogDepartment = dialogDepartment;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DeaprtmentAdd deaprtmentAdd = new DeaprtmentAdd();
        deaprtmentAdd.createDepartment(dialogDepartment);
    }
    
}
