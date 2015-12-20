/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.delete;

import java.awt.event.ActionListener;
import userinfo.gui.DeleteInfoDialog;

/**
 *
 * @author firsov
 */
public interface DeleteRow extends ActionListener{
 
    public void setDeleteInfoDialog(DeleteInfoDialog deleteInfoDialog);
}
