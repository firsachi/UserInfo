package userinfo.gui.strategyadd;

import userinfo.entities.RowEntities;
import userinfo.gui.DialogDepartment;

/**
 * Created by firsov on 05.10.2015.
 */

public class DepartmentAdd implements ButtonAddStartegy{
    
    private  final String title = "Новий відділ.";

    @Override
    public RowEntities add() {
        DialogDepartment dialogDepartment = new DialogDepartment();
        dialogDepartment.setTitle(title);
        return dialogDepartment.getDepartment();
    }
}
