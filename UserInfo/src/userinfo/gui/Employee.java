/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import toolsgui.ConfigComponentsGUI;
import toolsgui.UkrainianNameButton;
import userinfo.gui.lisenters.ButtonCanselActionListener;

/**
 *
 * @author firsov
 */
public class Employee extends JDialog{
    
    private JLabel labelError;
    private JLabel lanelName;
    private JLabel labelSurname;
    private JLabel labelPatronymic;
    private JLabel labelLogin;
    private JLabel labelPassword;
    private JLabel labelEmail;
    private JLabel labelDeaprtment;
    private JLabel labelPost;
    
    private JTextField textFieldName;
    private JTextField textFieldSurname;
    private JTextField textFieldPatronymic;
    private JTextField textFieldLogin;
    private JTextField textFieldPassword;
    private JTextField textFieldEmail;
    
    private final ConfigComponentsGUI configComponentsGUI;
    private JButton buttonOk;
    private JButton buttonCansel;
    
    public Employee() {
        configComponentsGUI = new UkrainianNameButton();
        configDialog();
    }
    
    private void configDialog(){
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        add(createErrorLabel(), BorderLayout.NORTH);
        add(createContentPanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
    }

    private Component createErrorLabel() {
        labelError = new JLabel(" ");
        JPanel panelError = new JPanel();
        panelError.setBorder(BorderFactory.createEmptyBorder(12, 12, 0, 12));
        panelError.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelError.add(labelError);
        return panelError;
    }

    private Component createContentPanel() {
        JPanel panelContent = new JPanel();
        panelContent.setBorder(BorderFactory.createEmptyBorder(0, 12, 0, 12));
        panelContent.setLayout(new GridLayout(0, 2, 5, 2));
        
        labelSurname = new JLabel("Прізвище");
        panelContent.add(labelSurname);
       
        textFieldSurname = new JTextField();
        panelContent.add(textFieldSurname);
        
        lanelName = new JLabel("Ім'я");
        panelContent.add(lanelName);
       
        textFieldName = new JTextField();
        panelContent.add(textFieldName);
       
        labelPatronymic = new JLabel("По батькові");
        panelContent.add(labelPatronymic);
        
        textFieldPatronymic = new JTextField();
        panelContent.add(textFieldPatronymic);
        
        labelLogin = new JLabel("Логін");
        panelContent.add(labelLogin);
        
        textFieldLogin = new JTextField();
        panelContent.add(textFieldLogin);
        
        labelPassword = new JLabel("Пароль");
        panelContent.add(labelPassword);
        
        textFieldPassword = new JTextField();
        panelContent.add(textFieldPassword);
        
        labelEmail = new JLabel("Електронна пошта");
        panelContent.add(labelEmail);
       
        textFieldEmail = new JTextField();
        textFieldEmail.setEditable(false);
        panelContent.add(textFieldEmail);
        return panelContent;
    }

    private Component createButtonPanel() {
        buttonOk = new JButton(configComponentsGUI.nameButtonOk());
        
        buttonCansel = new JButton(configComponentsGUI.nameButtonCansel());
        buttonCansel.addActionListener(new ButtonCanselActionListener((JDialog) this));
        
        JPanel panelGrid = new JPanel();
        panelGrid.setLayout(new GridLayout(1, 2, 5, 2));
        panelGrid.add(buttonOk);
        panelGrid.add(buttonCansel);
        
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelButtons.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        panelButtons.add(panelGrid);
        return panelButtons;
    }
}
