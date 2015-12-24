package userinfo.gui.strategyadd;

import userinfo.entities.RowEntities;
import userinfo.gui.frameuser.EnumNameModel;
import userinfo.gui.frameuser.tablemodel.TableModel;

/**
 * Created by firsov on 01.10.2015.
 */

public class StrategyAdd {
  
    private ButtonAddStartegy buttonAddStartegy;
    private RowEntities rowEntities;
    
    public StrategyAdd(){
       
    }
    
    public void result( TableModel tableModel, EnumNameModel nameModel){
        switch (nameModel){
            case USER :
                buttonAddStartegy = new UserAdd();
                break;
            case POST :
                buttonAddStartegy = new PostAdd();
                break;
            case DEPARTMENT :
                buttonAddStartegy = new DepartmentAdd();
                break;
        }
        rowEntities = buttonAddStartegy.add();
        if (rowEntities.getUpdate()){
            tableModel.addRow(rowEntities.getRow());
        }
    }
}
