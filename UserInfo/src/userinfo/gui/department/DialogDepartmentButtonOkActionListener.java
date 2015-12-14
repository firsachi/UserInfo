/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.department;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import userinfo.gui.DialogDepartment;

/**
 *
 * @author firsov
 */
public class DialogDepartmentButtonOkActionListener implements ActionListener {

    private final DialogDepartment dialogDepartment;
    
    public DialogDepartmentButtonOkActionListener(DialogDepartment dialogDepartment) {
        this.dialogDepartment = dialogDepartment;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ActionButtonOkDepartment actionButtonOkDepartment = new ActionButtonOkDepartment();
        actionButtonOkDepartment.runAction(dialogDepartment);
        
    }
    
}
