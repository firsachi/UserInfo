/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui.employee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import userinfo.gui.Employee;

/**
 *
 * @author firsov
 */
public class ButtonAddPostEmployeeActionListener implements ActionListener{

    private final Employee employee;
    
    public ButtonAddPostEmployeeActionListener(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PostAddButton postAddButton = new PostAddButton();
        postAddButton.createPost(employee.getComboBoxPost());
    }
    
}
