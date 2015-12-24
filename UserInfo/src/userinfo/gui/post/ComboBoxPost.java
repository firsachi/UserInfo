/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.post;

import java.util.ArrayList;
import javax.swing.JComboBox;
import userinfo.dao.DaoFactory;
import userinfo.dao.PostDAO;
import userinfo.entities.Post;

/**
 *
 * @author firsov
 */
public class ComboBoxPost extends JComboBox<Object>{
    
    private ArrayList<Post> arrayListPost;

    public ComboBoxPost() {
        DaoFactory daoFactory = DaoFactory.getInstance(DaoFactory.DaoType.POSTGRESQL);
        PostDAO postDao = daoFactory.createPostDAO();
        arrayListPost = postDao.findAll(false);
        fillComboBox();
    }

    private void fillComboBox() {
        for (Post post : arrayListPost){
            addItem(post.getPostName());
        }
    }

    public void addElement(Post post) {
        if (post.getUpdate()){
            arrayListPost.add(post);
            addItem(post.getPostName());
            setSelectedItem(post.getPostName());
        }
    }
    
    
}
