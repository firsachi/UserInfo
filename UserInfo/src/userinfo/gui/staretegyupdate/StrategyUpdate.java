/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.staretegyupdate;

import javax.swing.JTable;
import userinfo.entities.RowEntities;
import userinfo.gui.frameuser.EnumNameModel;
import userinfo.gui.frameuser.tablemodel.TableModel;

/**
 *
 * @author firsov
 */
public class StrategyUpdate {
    
    private ButtonUpdateStarategy buttonUpdateStarategy;
    private RowEntities rowEntities;

    public StrategyUpdate() {
    }
    
    public  void  resultStrategy(TableModel tableModel,JTable table, EnumNameModel nameModel){
        
        switch (nameModel){
            case USER:
                break;
            case POST:
                buttonUpdateStarategy = new PostUpdate();
                break;
            case DEPARTMENT:
                buttonUpdateStarategy = new DepartmentUpdate();
                break;
        }
        rowEntities = buttonUpdateStarategy.getUpdateRow((int) tableModel.getValueAt(table.getSelectedRow(), 0));
        if (rowEntities.getUpdate()){
            tableModel.updateRow(table.getSelectedRow(), rowEntities.getRow());
        }
    }
        
}
