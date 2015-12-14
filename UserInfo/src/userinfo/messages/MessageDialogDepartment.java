/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.messages;

/**
 *
 * @author firsov
 */
public class MessageDialogDepartment implements MessageInfo{

    @Override
    public String nullMaessage() {
        return "Назва відділу не повинна бути порожнім.";
    }

    @Override
    public String thereIs() {
        return "Відділ з такою назвою вже існує.";
    }
    
}
