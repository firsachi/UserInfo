/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui;

import userinfo.dao.DaoFactory;
import userinfo.dao.DepartmentDAO;

/**
 *
 * @author firsov
 */
public class DepartmentDelete {
    
    public void deleteDepartment(DeleteInfoDialog deleteInfoDialog){
        
        DaoFactory daoFactory = DaoFactory.getInstance(DaoFactory.DaoType.POSTGRESQL);
        DepartmentDAO departmentDAO = daoFactory.createDepartmentDAO();
        if(departmentDAO.delete(deleteInfoDialog.getId())){
            deleteInfoDialog.getLabelInfo().setText("<HTML><FONT color=\"red\">" + "Не можливо видалити запис бо за ним закрыплений користувач.");
            deleteInfoDialog.pack();
        }else{
            deleteInfoDialog.setResolveRemove(true);
            deleteInfoDialog.dispose();
        }   
        
    }
    
}
