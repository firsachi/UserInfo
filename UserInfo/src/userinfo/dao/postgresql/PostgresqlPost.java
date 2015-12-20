/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.dao.postgresql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    private Post post;
    
    @Override
    public Post create(Post post) {
        String query = "INSERT INTO post (name_post,unique_post) VALUES (?,?)";
        try (PreparedStatement preparedStatement = ReceiveConnect.getConnectionDatabase().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) 
        {
            preparedStatement.setString(1, post.getPostName());
            preparedStatement.setBoolean(2, post.getPostUnique());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                post.setPostID(resultSet.getInt(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlPost.class.getName()).log(Level.SEVERE, null, ex);
        }
        return post;
    }

    @Override
    public Post find(int idPost) {
        String query = "SELECT * FROM post WHERE id_post=?";
        try ( PreparedStatement preparedStatement = ReceiveConnect.getConnectionDatabase().prepareStatement(query);)
        {
            preparedStatement.setInt(1, idPost);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                post = getPost(resultSet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlPost.class.getName()).log(Level.SEVERE, null, ex);
        }
        return post;
    }

    @Override
    public ArrayList<Post> findAll(boolean delete) {
        String query = "SELECT * FROM post WHERE delete_post=? ORDER BY id_post";
        ArrayList<Post> arrayListPost = new ArrayList<>();
        try(PreparedStatement preparedStatement =ReceiveConnect.getConnectionDatabase().prepareStatement(query);) {
            preparedStatement.setBoolean(1, delete);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                arrayListPost.add(getPost(resultSet));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlPost.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayListPost;
    }

    @Override
    public boolean delete(int idPost) {
        boolean resultAction = false;
        String query = "UPDATE post SET delete_post=true WHERE id_post=? AND 0=(SELECT COUNT(*) FROM users WHERE id_post=?)";
        try(PreparedStatement preparedStatement = ReceiveConnect.getConnectionDatabase().prepareStatement(query);) 
        {
            preparedStatement.setInt(1, idPost);
            preparedStatement.setInt(2, idPost);
            if (0 < preparedStatement.executeUpdate()){
                resultAction = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlPost.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultAction;
    }

    @Override
    public boolean update(Post post) {
        boolean result = false;
        String query = "UPDATE post SET name_post=?,unique_post=? WHERE id_post=? AND delete_post=false AND 0=(SELECT COUNT(*) FROM post WHERE id_post!=? AND name_post=? AND delete_post=false)";
        try (
                PreparedStatement preparedStatement = ReceiveConnect.getConnectionDatabase().prepareStatement(query);
                )
        {
            preparedStatement.setString(1, post.getPostName());
            preparedStatement.setBoolean(2, post.getPostUnique());
            preparedStatement.setInt(3, post.getPostID());
            preparedStatement.setInt(4, post.getPostID());
            preparedStatement.setString(5, post.getPostName());
            int res = preparedStatement.executeUpdate();
            if (0 < res){
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlPost.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    private Post getPost(ResultSet resultSet) {
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

    @Override
    public boolean findName(String name) {
        boolean result = false;
        String query = "SELECT name_post FROM post WHERE name_post=? AND delete_post=false";
        try(PreparedStatement preparedStatement = ReceiveConnect.getConnectionDatabase().prepareStatement(query);) 
        {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            result = resultSet.next();
        } catch (SQLException ex) {
            Logger.getLogger(PostgresqlPost.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return result;
    }
    
}
