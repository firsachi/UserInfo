/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.employee;

import userinfo.gui.DialogPost;
import userinfo.gui.post.ComboBoxPost;

/**
 *
 * @author firsov
 */
class PostAddButton {

    void createPost(ComboBoxPost comboBoxPost) {
        DialogPost dialogPost = new DialogPost();
        dialogPost.pack();
        dialogPost.setLocationRelativeTo(null);
        dialogPost.setResizable(false);
        dialogPost.setVisible(true);
        comboBoxPost.addElement(dialogPost.getPost());
    }
    
}
