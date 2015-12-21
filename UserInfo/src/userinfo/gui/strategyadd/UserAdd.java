package userinfo.gui.strategyadd;

import userinfo.entities.RowEntities;
import userinfo.gui.Employee;

/**
 * Created by firsov on 01.10.2015.
 */
public class UserAdd implements ButtonAddStartegy{

    private RowEntities rowEntities;
    
    @Override
    public RowEntities add() {
        Employee employee = new Employee();
        employee.setTitle("Новий користувач");
        employee.pack();
        employee.setLocationRelativeTo(null);
        employee.setResizable(false);
        employee.setVisible(true);
        return rowEntities;
    }
}
