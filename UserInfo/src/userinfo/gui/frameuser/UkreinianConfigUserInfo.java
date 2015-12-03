/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.frameuser;

/**
 *
 * @author firsov
 */
public class UkreinianConfigUserInfo implements ConfigFrameUserInfo{

    @Override
    public String nameButtonAdd() {
        String name = "Додати";
        return name;
    }

    @Override
    public String nameButtonDelete() {
        String name = "Видалити";
        return name;
    }

    @Override
    public String nameButtonUpdate() {
        String name = "Змінити";
        return name;
    }

    @Override
    public String nameToggleButtonUser() {
        String name = "Користувачі";
        return name;
    }

    @Override
    public String nameToggleButtonPost() {
        String name = "Посади";
        return name;
    }

    @Override
    public String nameToggleButtonDeaprtment() {
        String name = "Відділи";
        return  name;
    }
    
}
