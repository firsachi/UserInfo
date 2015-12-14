/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.strategydelete;

/**
 *
 * @author firsov
 */
public class ContextStrategyDelete {
    private ButtonDeleteStrategy buttonDeleteStrategy;
    
    public void setButtonDeleteStrategy(ButtonDeleteStrategy buttonDeleteStrategy){
        this.buttonDeleteStrategy = buttonDeleteStrategy;
    }
    
    public void executeDelete(int id){
        buttonDeleteStrategy.deleteRow(id);
    }
}
