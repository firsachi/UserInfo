package userinfo.gui.strategyadd;

import userinfo.gui.frameuser.EnumNameModel;
import userinfo.gui.frameuser.tablemodel.TableModel;

/**
 * Created by firsov on 01.10.2015.
 */

public class StrategyAdd {

    private final ContextStrategyAdd contextStrategyAdd;
    private Object[] resultObjekt;
    
    public StrategyAdd(){
        contextStrategyAdd = new ContextStrategyAdd();
    }
    
    public void result( TableModel tableModel, EnumNameModel nameModel){
        switch (nameModel){
            case USER :
               
                break;
            case POST :
                
                break;
            case DEPARTMENT :
                DepartmentAdd departmentAdd =new DepartmentAdd();
                resultObjekt = departmentAdd.add();
                break;
        }
        if (resultObjekt != null){
            tableModel.addRow(resultObjekt);
        }
    }

}
