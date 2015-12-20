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
    boolean findName(String name);
    ArrayList<Post> findAll(boolean delete);
    boolean delete(int idPost);
    boolean update(Post post);
}
