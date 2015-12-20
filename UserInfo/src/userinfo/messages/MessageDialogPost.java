/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.messages;

import userinfo.messages.MessageInfo;

/**
 *
 * @author firsov
 */
public class MessageDialogPost implements MessageInfo {

    public MessageDialogPost() {
    }

    @Override
    public String thereIs() {
        return "Назва посади не повинна бути порожньою.";
    }

    @Override
    public String nullMaessage() {
        return "Посада з такою назвою вже існує.";
    }
    
}
