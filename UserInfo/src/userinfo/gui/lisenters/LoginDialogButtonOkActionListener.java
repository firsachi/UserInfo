/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.lisenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import userinfo.gui.DialogLogin;
import userinfo.gui.FrameUserInfo;

/**
 *
 * @author firsov
 */
public class LoginDialogButtonOkActionListener implements ActionListener{

    private final DialogLogin dialogLogin;
    
    public LoginDialogButtonOkActionListener(DialogLogin dialogLogin) {
        this.dialogLogin = dialogLogin;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        dialogLogin.dispose();
        FrameUserInfo frameUserInfo = new FrameUserInfo();
    }
    
}
