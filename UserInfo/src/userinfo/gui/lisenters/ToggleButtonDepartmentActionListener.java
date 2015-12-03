/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.lisenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import userinfo.gui.FrameUserInfo;
import userinfo.gui.frameuser.EnumNameModel;
import userinfo.gui.frameuser.tablemodel.FillTableModel;

/**
 *
 * @author firsov
 */
public class ToggleButtonDepartmentActionListener implements ActionListener{
    
    private final FrameUserInfo frameUserInfo;
    
    public ToggleButtonDepartmentActionListener(FrameUserInfo frameUserInfo) {
        this.frameUserInfo = frameUserInfo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FillTableModel fillTable = new FillTableModel();
        fillTable.fillTable(frameUserInfo.getTableModelFrame(), EnumNameModel.DEPARTMENT);
    }
    
}