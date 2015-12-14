/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.lisenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import userinfo.gui.FrameUserInfo;
import userinfo.gui.staretegyupdate.StrategyUpdate;

/**
 *
 * @author firsov
 */
public class ButtonUpdateActionListener implements ActionListener{
    
    private final FrameUserInfo frameUserInfo;

    public ButtonUpdateActionListener(FrameUserInfo frameUserInfo) {
        this.frameUserInfo = frameUserInfo;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        StrategyUpdate strategyUpdate = new StrategyUpdate();
        strategyUpdate.resultStrategy(frameUserInfo.getTableModelFrame(), frameUserInfo.getTableFrame(), frameUserInfo.getNameModel());
    }
    
}
