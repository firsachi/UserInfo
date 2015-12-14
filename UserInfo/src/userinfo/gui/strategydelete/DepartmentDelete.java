/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.strategydelete;

import userinfo.gui.DeleteInfoDialog;

/**
 *
 * @author firsov
 */
public class DepartmentDelete implements ButtonDeleteStrategy{

    @Override
    public boolean deleteRow(int id) {
        DeleteInfoDialog deleteInfoDialog = new DeleteInfoDialog(id);
        return deleteInfoDialog.getResolveRemove();
    }
    
}
