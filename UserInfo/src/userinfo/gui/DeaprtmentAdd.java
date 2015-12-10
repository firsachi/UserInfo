/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui;

import userinfo.dao.DaoFactory;
import userinfo.dao.DepartmentDAO;
import userinfo.entities.Department;
/**
 *
 * @author firsov
 */
class DeaprtmentAdd {
    
    private Department department;
    
    void createDepartment(DialogDepartment dialogDepartment){
        department = new Department();
        department.setDepartmentName(dialogDepartment.getTextFieldNameDepartment());
        DaoFactory daoFactory = DaoFactory.getInstance(DaoFactory.DaoType.POSTGRESQL);
        DepartmentDAO departmentDAO = daoFactory.createDepartmentDAO();
        if (checkNotNull(dialogDepartment.getTextFieldNameDepartment())){
            dialogDepartment.getLabelError().setText("<HTML><FONT color=\"red\"> Поле выдмычене криним не повинно бути порожнім.");
            dialogDepartment.getLabelName().setText("<HTML><FONT color=\"red\">"+ dialogDepartment.getLabelName().getText() );
        }else if (departmentDAO.findName(department)) {
            dialogDepartment.setDepartment(departmentDAO.create(department));
            dialogDepartment.dispose();
        }else{
            dialogDepartment.getLabelError().setText("<HTML><FONT color=\"red\"> Відділ з такою назвою вже існує.");
            dialogDepartment.getLabelName().setText("<HTML><FONT color=\"red\">"+ dialogDepartment.getLabelName().getText() );
        }
    }
    
    private boolean checkNotNull(String text){
        boolean result = false;
        if (text.trim().length() == 0){
            result=true;
        }
        return result;
    }
}
