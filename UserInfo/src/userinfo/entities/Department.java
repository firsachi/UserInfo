package userinfo.entities;

/**
 * Created by firsov on 22.09.2015.
 */
public class Department implements RowEntities{
    
    private boolean update = false;
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

    @Override
    public void setUpdate(boolean update) {
        this.update = update;
    }

    @Override
    public boolean getUpdate() {
        return update;
    }

}
