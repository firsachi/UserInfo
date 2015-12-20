/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.lisenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import userinfo.gui.FrameUserInfo;
import userinfo.gui.frameuser.ConfigFrameUserInfo;
import userinfo.gui.frameuser.EnumNameModel;
import userinfo.gui.frameuser.UkreinianConfigUserInfo;
import userinfo.gui.frameuser.tablemodel.FillTableModel;

/**
 *
 * @author firsov
 */
public class ToggleButtonUserActionListener implements ActionListener{

    private final FrameUserInfo frameUserInfo;
    private final ConfigFrameUserInfo configFrameUserInfo = new UkreinianConfigUserInfo();
    
    public ToggleButtonUserActionListener(FrameUserInfo frameUserInfo) {
        this.frameUserInfo = frameUserInfo;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        frameUserInfo.setNameModel(EnumNameModel.USER);
        FillTableModel filltable = new FillTableModel();
        filltable.fillTable(frameUserInfo.getTableModelFrame(), frameUserInfo.getNameModel(), false);
        frameUserInfo.setTitle(configFrameUserInfo.nameToggleButtonUser());
        frameUserInfo.selectRowTable();
    }
    
}
