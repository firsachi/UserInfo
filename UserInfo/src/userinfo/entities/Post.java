package userinfo.entities;

/**
 * Created by firsov on 24.09.2015.
 */
public class Post implements RowEntities{

    private boolean flag = false;
    private int postID;
    private String postName;
    private boolean postUnique;
    private boolean postBusy;

    public Post(){
        this.postID=0;
    }

    public void setPostID(int postID){
        this.postID=postID;
    }
    public  void setPostName(String postName){
        this.postName=postName;
    }
    public  void  setPostUnique(boolean postUnique){
        this.postUnique=postUnique;
    }
    public void setPostBusy(boolean postBusy){
        this.postBusy=postBusy;
    }

    public int getPostID(){
        return postID;
    }
    public String getPostName(){
        return postName;
    }
    public boolean getPostUnique(){
        return  postUnique;
    }
    public  boolean getPostBusy(){
        return postBusy;
    }

    @Override
    public Object[] getRow() {
        Object[] rowData = new Object[]{postID, postName};
        return rowData;
    }

    @Override
    public void setUpdate(boolean update) {
        this.flag = update;
    }

    @Override
    public boolean getUpdate() {
        return flag;
    }
}
