/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.frameuser.tablemodel;

import userinfo.gui.frameuser.EnumNameModel;

/**
 *
 * @author firsov
 */
public class FillTableModel {

    public FillTableModel() {
    }
       
    public void fillTable(TableModel tableModel,EnumNameModel enumNameModel){
        tableModel.clearTableModel();
        switch (enumNameModel){
            case USER:
                tableModel.addNameColumn(new UserNameColumn());
                break;
            case POST:
                tableModel.addNameColumn(new PostNameColumn());
                break;
            case DEPARTMENT:
                tableModel.addNameColumn(new DepartmentNameColumn());
                break;
        }
    }
}
