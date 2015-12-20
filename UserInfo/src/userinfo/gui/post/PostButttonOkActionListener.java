/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.post;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import userinfo.gui.DialogPost;

/**
 *
 * @author firsov
 */
public class PostButttonOkActionListener implements ActionListener{
    
    private final DialogPost dialogPost;

    public PostButttonOkActionListener(DialogPost dialogPost) {
        this.dialogPost = dialogPost;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        WorkPost workPost = new WorkPost();
        switch (dialogPost.getAction()){
            case INSERT:
                workPost.insertNewPost(dialogPost);
                break;
            case UPDATE:
                workPost.updatePost(dialogPost);
                break;
                
        }
        
    }
    
}
