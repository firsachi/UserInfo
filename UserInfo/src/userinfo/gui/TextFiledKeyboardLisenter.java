/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 *
 * @author firsov
 */
class TextFiledKeyboardLisenter implements KeyListener {
    
    private final DialogDepartment dialogDepartment;
    
    TextFiledKeyboardLisenter(DialogDepartment dialogDepartment) {
        this.dialogDepartment = dialogDepartment;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (dialogDepartment.getTextFieldNameDepartment().trim().length() > 0){
            dialogDepartment.getLabelError().setText(" ");
        }
        
    }
    
}
