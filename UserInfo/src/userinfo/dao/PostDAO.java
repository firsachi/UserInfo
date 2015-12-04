/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.dao;

import java.util.ArrayList;
import userinfo.entities.Post;

/**
 *
 * @author firsov
 */
public interface PostDAO {
    
    Post create(Post post);
    Post find(int idPost);
    ArrayList<Post> findAll(boolean delete);
    void delete(int idPost);
    void update(Post post);
}
