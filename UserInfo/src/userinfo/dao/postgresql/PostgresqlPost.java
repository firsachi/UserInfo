/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.dao.postgresql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import userinfo.dao.PostDAO;
import userinfo.databases.ReceiveConnect;
import userinfo.entities.Post;

/**
 *
 * @author firsov
 */
public class PostgresqlPost  implements PostDAO{

    @Override
    public Post create(Post post) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Post find(int idPost) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Post> findAll(boolean delete) {
        String query = "SELECT * FROM post WHERE delete_post=?";
        ArrayList<Post> arrayListPost = new ArrayList<>();
        try(PreparedStatement preparedStatement =ReceiveConnect.getConnectionDatabase().prepareStatement(query);) {
            preparedStatement.setBoolean(1, delete);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                arrayListPost.add(getPOst(resultSet));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlPost.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayListPost;
    }

    @Override
    public void delete(int idPost) {
        String query = "UPDATE post SET delete_post=true WHERE id_post=?";
        try(
                PreparedStatement preparedStatement = ReceiveConnect.getConnectionDatabase().prepareStatement(query);
                ) 
        {
            preparedStatement.setInt(1, idPost);
            preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlPost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Post post) {
        String query = "UPDATE post SET name_post=? WHERE id_post=?";
        try (
                PreparedStatement preparedStatement = ReceiveConnect.getConnectionDatabase().prepareStatement(query);
                )
        {
            preparedStatement.setString(1, post.getPostName());
            preparedStatement.setInt(2, post.getPostID());
            preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlPost.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Post getPOst(ResultSet resultSet) {
        Post post = new Post();
        try {
            post.setPostID(resultSet.getInt(1));
            post.setPostName(resultSet.getString(2));
            post.setPostUnique(resultSet.getBoolean(4));
            post.setPostBusy(resultSet.getBoolean(5));
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlPost.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return post;
    }
    
}
