package userinfo.gui.strategyadd;

import userinfo.entities.RowEntities;
import userinfo.gui.frameuser.EnumNameModel;
import userinfo.gui.frameuser.tablemodel.TableModel;

/**
 * Created by firsov on 01.10.2015.
 */

public class StrategyAdd {
  
    private RowEntities rowEntities;
    
    public StrategyAdd(){
       
    }
    
    public void result( TableModel tableModel, EnumNameModel nameModel){
        switch (nameModel){
            case USER :
               
                break;
            case POST :
                PostAdd postAdd = new PostAdd();
                rowEntities = postAdd.add();
                break;
            case DEPARTMENT :
                DepartmentAdd departmentAdd = new DepartmentAdd();
                rowEntities = departmentAdd.add();
                break;
        }
        if (rowEntities != null){
            tableModel.addRow(rowEntities.getRow());
        }
    }
}
