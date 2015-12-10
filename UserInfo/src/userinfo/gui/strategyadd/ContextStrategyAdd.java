package userinfo.gui.strategyadd;

import userinfo.entities.RowEntities;

/**
 * Created by firsov on 01.10.2015.
 */
public class ContextStrategyAdd {

    private ButtonAddStartegy buttonAddStartegy;

    public ContextStrategyAdd(){

    }

    public void setButtonStrategyAdd(ButtonAddStartegy buttonAddStartegy){
        this.buttonAddStartegy = buttonAddStartegy;
    }

    public RowEntities executeNewRow(){
        return buttonAddStartegy.add();
    }
}
