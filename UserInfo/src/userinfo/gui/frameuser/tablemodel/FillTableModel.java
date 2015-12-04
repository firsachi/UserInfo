/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.frameuser.tablemodel;

import userinfo.dao.DaoFactory;
import userinfo.dao.DepartmentDAO;
import userinfo.dao.PostDAO;
import userinfo.dao.UsersDAO;
import userinfo.entities.RowEntities;
import userinfo.gui.frameuser.EnumNameModel;

/**
 *
 * @author firsov
 */
public class FillTableModel {

    private DaoFactory factory;
    
    public FillTableModel() {
    }
       
    public void fillTable(TableModel tableModel,EnumNameModel enumNameModel, boolean delete){
        tableModel.clearTableModel();
        switch (enumNameModel){
            case USER:
                tableModel.addNameColumn(new UserNameColumn());
                factory = DaoFactory.getInstance(DaoFactory.DaoType.POSTGRESQL);
                UsersDAO usersDAO = factory.createUsersDAO();
                for (RowEntities rowData : usersDAO.findAll(delete) ){
                    tableModel.addRow(rowData.getRow());
                }
                break;
            case POST:
                tableModel.addNameColumn(new PostNameColumn());
                factory = DaoFactory.getInstance(DaoFactory.DaoType.POSTGRESQL);
                PostDAO postDAO = factory.createPostDAO();
                for (RowEntities rowData : postDAO.findAll(delete)){
                    tableModel.addRow(rowData.getRow());
                }
                break;
            case DEPARTMENT:
                tableModel.addNameColumn(new DepartmentNameColumn());
                factory = DaoFactory.getInstance(DaoFactory.DaoType.POSTGRESQL);
                DepartmentDAO departmentDAO = factory.createDepartmentDAO();
                for (RowEntities rowData : departmentDAO.findAll(delete)){
                    tableModel.addRow(rowData.getRow());
                }
                break;
        }
    }
}
