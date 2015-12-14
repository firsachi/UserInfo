/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.staretegyupdate;

import javax.swing.JTable;
import userinfo.entities.Department;
import userinfo.entities.RowEntities;
import userinfo.gui.frameuser.EnumNameModel;
import userinfo.gui.frameuser.tablemodel.TableModel;

/**
 *
 * @author firsov
 */
public class StrategyUpdate {
    
    private RowEntities rowEntities;

    public StrategyUpdate() {
    }
    
    public  void  resultStrategy(TableModel tableModel,JTable table, EnumNameModel nameModel){
        
        switch (nameModel){
            case USER:
                break;
            case POST:
                break;
            case DEPARTMENT:
                Department department = new Department();
                department.setIdDepartment((int) tableModel.getValueAt(table.getSelectedRow(), 0));
                department.setDepartmentName((String)tableModel.getValueAt(table.getSelectedRow(), 1));
                DepartmentUpdate departmentUpdate = new DepartmentUpdate();
                rowEntities = departmentUpdate.getUpdateRow(department);
                break;
        }
        if (rowEntities != null){
            
        }
    }
    
}
