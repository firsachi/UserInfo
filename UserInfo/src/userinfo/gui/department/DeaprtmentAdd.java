/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.department;

import userinfo.dao.DaoFactory;
import userinfo.dao.DepartmentDAO;
import userinfo.entities.Department;
import userinfo.gui.DialogDepartment;
import userinfo.messages.MessageDialogDepartment;
import userinfo.messages.MessageInfo;
/**
 *
 * @author firsov
 */
class DeaprtmentAdd {
    
    private Department department;
    private final MessageInfo messageInfo = new MessageDialogDepartment();
    
    void createDepartment(DialogDepartment dialogDepartment){
        department = new Department();
        department.setDepartmentName(dialogDepartment.getTextFieldNameDepartment());
        DaoFactory daoFactory = DaoFactory.getInstance(DaoFactory.DaoType.POSTGRESQL);
        DepartmentDAO departmentDAO = daoFactory.createDepartmentDAO();
        if (checkNotNull(dialogDepartment.getTextFieldNameDepartment())){
            dialogDepartment.getLabelError().setText("<HTML><FONT color=\"red\">" + messageInfo.nullMaessage());
            dialogDepartment.getLabelName().setText("<HTML><FONT color=\"red\">"+ dialogDepartment.getLabelName().getText() );
        }else if (departmentDAO.findName(department)) {
            dialogDepartment.setDepartment(departmentDAO.create(department));
            dialogDepartment.dispose();
        }else{
            dialogDepartment.getLabelError().setText("<HTML><FONT color=\"red\">" + messageInfo.thereIs());
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
