/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.post;

import userinfo.dao.DaoFactory;
import userinfo.dao.PostDAO;
import userinfo.gui.DeleteInfoDialog;

/**
 *
 * @author firsov
 */
public class DeletePost {

    public DeletePost() {
    }
    
    
    public void depetePost(DeleteInfoDialog deleteInfoDialog){
        DaoFactory daoFactory = DaoFactory.getInstance(DaoFactory.DaoType.POSTGRESQL);
        PostDAO postDAO = daoFactory.createPostDAO();
        if(postDAO.delete(deleteInfoDialog.getId())){
            deleteInfoDialog.getLabelInfo().setText("<HTML><FONT color=\"red\">" + "Не можливо видалити запис бо за ним закріплений користувач.");
            deleteInfoDialog.pack();
        }else{
            deleteInfoDialog.setResolveRemove(true);
            deleteInfoDialog.dispose();
        }
    }
    
}
