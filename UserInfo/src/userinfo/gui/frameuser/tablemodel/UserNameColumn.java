/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.frameuser.tablemodel;

/**
 *
 * @author firsov
 */
public class UserNameColumn implements NameColumn {

    @Override
    public String[] getNAmeColumn() {
        String[] nameColumn = new String[]{"Код","П.І.Б","Логін","Пароль","Електронна пошта","Відділ","Посада"};
        return nameColumn;
    }
    
}
