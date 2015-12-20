/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.post;

import userinfo.messages.MessageDialogPost;
import userinfo.dao.DaoFactory;
import userinfo.dao.PostDAO;
import userinfo.entities.Post;
import userinfo.gui.DialogPost;
import userinfo.messages.MessageInfo;

/**
 *
 * @author firsov
 */
class WorkPost {
    
    private Post post;
    private final MessageInfo messageInfo = new MessageDialogPost();

    void insertNewPost(DialogPost dialogPost) {
        DaoFactory daoFactory = DaoFactory.getInstance(DaoFactory.DaoType.POSTGRESQL);
        PostDAO postDAO = daoFactory.createPostDAO();
        post = new Post();
        post.setPostName(dialogPost.getTextNamePost());
        post.setPostUnique(dialogPost.getUniquePost());
        if (checkNotNull(post.getPostName())){
            dialogPost.getLabelError().setText("<HTML><FONT color=\"red\">" + messageInfo.nullMaessage());
            dialogPost.getLabelName().setText("<HTML><FONT color=\"red\">" + dialogPost.getLabelName().getText());
        }else if(postDAO.findName(post.getPostName())){
            dialogPost.getLabelError().setText("<HTML><FONT color=\"red\">" + messageInfo.thereIs());
            dialogPost.getLabelName().setText("<HTML><FONT color=\"red\">" + dialogPost.getLabelName().getText());
        }else{
            dialogPost.setPost(postDAO.create(post));
            dialogPost.dispose();
        }
        
    }
    
    void updatePost(DialogPost dialogPost){
        DaoFactory daoFactory = DaoFactory.getInstance(DaoFactory.DaoType.POSTGRESQL);
        PostDAO postDAO = daoFactory.createPostDAO();
        if (checkNotNull(dialogPost.getPost().getPostName())){
            dialogPost.getLabelError().setText("<HTML><FONT color=\"red\">" + messageInfo.nullMaessage());
            dialogPost.getLabelName().setText("<HTML><FONT color=\"red\">" + dialogPost.getLabelName().getText());
        }else if(postDAO.update(dialogPost.getPost())){
            dialogPost.getPost().setUpdate(true);
            dialogPost.dispose();
        }else{
            dialogPost.getLabelError().setText("<HTML><FONT color=\"red\">" + messageInfo.thereIs());
            dialogPost.getLabelName().setText("<HTML><FONT color=\"red\">" + dialogPost.getLabelName().getText());
        }
    }
    
    private boolean checkNotNull(String text){
        if (text.length() == 0){
            return true;
        }else {
            return false;
        }
    }
}
