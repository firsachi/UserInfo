package userinfo.entities;

/**
 * Created by firsov on 22.09.2015.
 */
public class Department implements RowEntities{

    private int idDepartment;
    private String departmentName;

    public Department(){
        this.idDepartment=0;
    }

    public void setIdDepartment(int idDepartment){
        this.idDepartment=idDepartment;
    }

    public void setDepartmentName(String departmentName){
        this.departmentName=departmentName;
    }

    public int getIdDepartment(){
        return idDepartment;
    }

       public String getDepartmentName(){
        return departmentName;
    }

    @Override
    public String[] getRow() {
        String[] row = new String[]{Integer.toString(idDepartment), departmentName};
        return row;
    }
}
