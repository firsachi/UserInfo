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
class PostNameColumn implements NameColumn {

    public PostNameColumn() {
    }

    @Override
    public String[] getNAmeColumn() {
        String[] nameColumn =new String[] {"Код","Найменування"};
        return nameColumn;
    }
    
}
