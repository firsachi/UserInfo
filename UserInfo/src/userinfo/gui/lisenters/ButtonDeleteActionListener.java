/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.lisenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import userinfo.gui.FrameUserInfo;
import userinfo.gui.strategydelete.StrategyDelete;

/**
 *
 * @author firsov
 */
public class ButtonDeleteActionListener implements ActionListener{
    
    private final FrameUserInfo frameUserInfo;

    public ButtonDeleteActionListener(FrameUserInfo frameUserInfo) {
        this.frameUserInfo = frameUserInfo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StrategyDelete strategyDelete = new StrategyDelete();
        strategyDelete.resultDelete(frameUserInfo.getTableModelFrame(), frameUserInfo.getTableFrame(), frameUserInfo.getNameModel());
    }

    
}
