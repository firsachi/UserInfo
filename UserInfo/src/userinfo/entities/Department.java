package userinfo.entities;

/**
 * Created by firsov on 22.09.2015.
 */
public class Department implements RowEntities{

    private int idDepartment;
    private String departmentName;

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
    public Object[] getRow() {
        Object[] rowData = new Object[]{idDepartment, departmentName};
        return rowData;
    }
}
