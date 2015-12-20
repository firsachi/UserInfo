/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.staretegyupdate;

import userinfo.dao.DaoFactory;
import userinfo.dao.PostDAO;
import userinfo.entities.RowEntities;
import userinfo.gui.DialogPost;

/**
 *
 * @author firsov
 */
public class PostUpdate implements ButtonUpdateStarategy{

    private RowEntities rowEntities;
    
    @Override
    public RowEntities getUpdateRow(int idValue) {
        DaoFactory factory = DaoFactory.getInstance(DaoFactory.DaoType.POSTGRESQL);
        PostDAO postDAO = factory.createPostDAO();
        DialogPost dialogPost = new DialogPost();
        dialogPost.setTitle("Редагувати посаду");
        dialogPost.setPost(postDAO.find(idValue));
        dialogPost.pack();
        dialogPost.setLocationRelativeTo(null);
        dialogPost.setResizable(false);
        dialogPost.setVisible(true);
        rowEntities = dialogPost.getPost();
        return rowEntities;
    }
    
}
