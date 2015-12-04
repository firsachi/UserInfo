/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.lisenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import userinfo.gui.FrameUserInfo;
import userinfo.gui.strategyadd.StrategyAdd;

/**
 *
 * @author firsov
 */
public class ButtonAddActionListener implements ActionListener{
    
    private final FrameUserInfo frameUserInfo;
    
    public ButtonAddActionListener(FrameUserInfo frameUserInfo) {
        this.frameUserInfo = frameUserInfo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StrategyAdd strategyAdd = new StrategyAdd();
        strategyAdd.result(frameUserInfo.getTableModelFrame(), frameUserInfo.getNameModel());
    }
    
}
