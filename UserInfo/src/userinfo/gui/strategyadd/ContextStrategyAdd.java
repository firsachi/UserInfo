package userinfo.gui.strategyadd;

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

    public Object[] executeNewRow(){
        return buttonAddStartegy.add();
    }
}
