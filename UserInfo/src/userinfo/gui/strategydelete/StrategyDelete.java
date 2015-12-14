/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.strategydelete;

import javax.swing.JTable;
import userinfo.gui.frameuser.EnumNameModel;
import userinfo.gui.frameuser.tablemodel.TableModel;

/**
 *
 * @author firsov
 */
public class StrategyDelete {
    
    private final ContextStrategyDelete contextStrategyDelete;

    public StrategyDelete() {
        contextStrategyDelete = new ContextStrategyDelete();
    }
    
    public void resultDelete(TableModel tableModel,JTable table, EnumNameModel nameModel){
        int id = (int) tableModel.getValueAt(table.getSelectedRow(), 0);
        boolean deleteTableRow = false;
        switch (nameModel){
            case USER:
                break;
            case POST:
                break;
            case DEPARTMENT:
                DepartmentDelete departmentDelete = new DepartmentDelete();
                deleteTableRow = departmentDelete.deleteRow(id);
                break;
        }
        if (deleteTableRow){
            tableModel.removeRow(table.getSelectedRow());
        }
        
    }
}
