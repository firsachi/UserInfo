package userinfo.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by firsov on 12.09.15.
 */
public class Users implements RowEntities{
    private boolean flag = false;
    private final String[] nameComponent={"idUsers","nameUsers","surnameUser","patronymicUsers","loginUsers","passwordUser","emailUsers","departmentUsers","postUsers"};
    private final Map userMap=new HashMap<String, String>();

    public Users(){
        for (String value:nameComponent){
            userMap.put(value, null);
        }
    }
    public void setIdUsers(int  idUsers){
        this.userMap.put(nameComponent[0], idUsers);
    }
    public void setNameUsers(String nameUsers){
        this.userMap.put(nameComponent[1], nameUsers);
    }
    public void setSurnameUser(String surnameUser){
        this.userMap.put(nameComponent[2], surnameUser);
    }
    public void setPatronymicUsers(String patronymicUsers){
        this.userMap.put(nameComponent[3], patronymicUsers);
    }
    public void setLoginUsers(String loginUsers){
        this.userMap.put(nameComponent[4], loginUsers);
    }
    public void setPaswordUsers(String paswordUsers){
        this.userMap.put(nameComponent[5], paswordUsers);
    }
    public void setEmailUsers(String emailUsers){
        this.userMap.put(nameComponent[6], emailUsers);
    }
    public void setDepartmentUsers(String departmentUsers){
        this.userMap.put(nameComponent[7], departmentUsers);
    }
    public void setPostUsers(String postUsers){
        this.userMap.put(nameComponent[8], postUsers);
    }

    public int getIdUsers(){
        return (int) this.userMap.get(nameComponent[0]);
    }
    public String getNameUsers(){
        return (String) this.userMap.get(nameComponent[1]);
    }
    public String getSurnameUser(){
        return (String) this.userMap.get(nameComponent[2]);
    }
    public String getPatronymicUsers(){
        return (String) this.userMap.get(nameComponent[3]);
    }
    public String getLoginUsers(){
        return (String) this.userMap.get(nameComponent[4]);
    }
    public String getPaswordUsers(){
        return (String) this.userMap.get(nameComponent[5]);
    }
    public String getEmailUsers(){
        return (String) this.userMap.get(nameComponent[6]);
    }
    public String  getDepartmentUsers(){
        return (String) this.userMap.get(nameComponent[7]);
    }
    public String getPostUsers(){
        return (String) this.userMap.get(nameComponent[8]);
    }

    public void setComponent(int number, String value){
        userMap.put(nameComponent[number-1], value);
    }

    public String getString(int index){
        return nameComponent[index];
    }

    @Override
    public Object[] getRow() {
        Object[] rowData = new Object[]{
            userMap.get(nameComponent[0]), 
            userMap.get(nameComponent[2]) + " " + userMap.get(nameComponent[1]) + " " + userMap.get(nameComponent[3]),
            userMap.get(nameComponent[4]), 
            userMap.get(nameComponent[5]), 
            userMap.get(nameComponent[6]),
            userMap.get(nameComponent[7]), 
            userMap.get(nameComponent[8])
        };
        
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
