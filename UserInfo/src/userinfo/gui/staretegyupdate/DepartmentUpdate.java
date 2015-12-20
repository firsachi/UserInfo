/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.staretegyupdate;


import userinfo.dao.DaoFactory;
import userinfo.dao.DepartmentDAO;
import userinfo.entities.RowEntities;
import userinfo.gui.DialogDepartment;

/**
 *
 * @author firsov
 */
class DepartmentUpdate implements ButtonUpdateStarategy{
    
    private final String title = "Змінити назву відділу.";    
    @Override
    public RowEntities getUpdateRow(int idValue) {
        DaoFactory daoFactory = DaoFactory.getInstance(DaoFactory.DaoType.POSTGRESQL);
        DepartmentDAO departmentDAO = daoFactory.createDepartmentDAO();
        DialogDepartment dialogDepartment = new DialogDepartment(title);
        dialogDepartment.setDepartment(departmentDAO.find(idValue));
        dialogDepartment.pack();
        dialogDepartment.setLocationRelativeTo(null);
        dialogDepartment.setResizable(false);
        dialogDepartment.setVisible(true);
        return dialogDepartment.getDepartment();
    }
    
}
