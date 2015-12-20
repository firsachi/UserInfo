/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.strategydelete;

import java.awt.event.ActionEvent;
import userinfo.gui.DeleteInfoDialog;
import userinfo.gui.delete.DeleteRow;
import userinfo.gui.post.DeletePost;


/**
 *
 * @author firsov
 */
class DeletePostDialogButtonOkActionListenet implements DeleteRow {

    private DeleteInfoDialog deleteInfoDialog;
    
    public DeletePostDialogButtonOkActionListenet() {
    }

    @Override
    public void setDeleteInfoDialog(DeleteInfoDialog deleteInfoDialog) {
        this.deleteInfoDialog = deleteInfoDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DeletePost postDelete = new DeletePost();
        postDelete.depetePost(deleteInfoDialog);
    }
    
}
