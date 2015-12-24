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
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import toolsgui.ConfigComponentsGUI;
import toolsgui.ResizeComponentsFrame;
import toolsgui.UkrainianNameButton;
import userinfo.gui.department.ComboBoxDepartment;
import userinfo.gui.employee.ButtonAddDepartmentEmployeeActionLIstener;
import userinfo.gui.employee.ButtonAddPostEmployeeActionListener;
import userinfo.gui.lisenters.ButtonCanselActionListener;
import userinfo.gui.post.ComboBoxPost;

/**
 *
 * @author firsov
 */
public class Employee extends JDialog{
    
    private JLabel labelError;
    private JLabel labelName;
    private JLabel labelSurname;
    private JLabel labelPatronymic;
    private JLabel labelLogin;
    private JLabel labelPassword;
    private JLabel labelEmail;
    private JLabel labelDepartment;
    private JLabel labelPost;
    
    private final int textFieldSize = 25;
    private final int horizontalStrut =6;
    private final int verticalStrut = 2;
    
    private JTextField textFieldName;
    private JTextField textFieldSurname;
    private JTextField textFieldPatronymic;
    private JTextField textFieldLogin;
    private JTextField textFieldPassword;
    private JTextField textFieldEmail;
    
    private ComboBoxDepartment comboBoxDepartment;
    private ComboBoxPost comboBoxPost;
    
    private JPanel panelPass;
    private JPanel panelDeparmentEntities;
    private JPanel panelPostEntities;
    
    private JButton buttonGenPass;
    private JButton buttonAddDepartment;
    private JButton buttonAddPost;
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
        panelContent.setLayout(new BoxLayout(panelContent, BoxLayout.PAGE_AXIS));
        panelContent.add(createPanelSurname());
        panelContent.add(Box.createVerticalStrut(verticalStrut));
        panelContent.add(createPanelName());
        panelContent.add(Box.createVerticalStrut(verticalStrut));
        panelContent.add(createPanelPatronymic());
        panelContent.add(Box.createVerticalStrut(verticalStrut));
        panelContent.add(createPanelLogin());        
        panelContent.add(Box.createVerticalStrut(verticalStrut));
        panelContent.add(createPanelPassword());       
        panelContent.add(Box.createVerticalStrut(verticalStrut));
        panelContent.add(createPanelEmail());
        panelContent.add(Box.createVerticalStrut(verticalStrut));
        panelContent.add(createPanelDepartment());
        panelContent.add(Box.createVerticalStrut(verticalStrut));
        panelContent.add(createPanelPost());
        ResizeComponentsFrame resizeComponentsFrame = new ResizeComponentsFrame();
        resizeComponentsFrame.sizeComponents(labelSurname, labelName, labelPatronymic, labelLogin, labelPassword, labelEmail, labelDepartment, labelPost);
        resizeComponentsFrame.sizeComponents(textFieldEmail, textFieldLogin , textFieldName, textFieldSurname, textFieldPatronymic, textFieldPatronymic, panelPass, panelDeparmentEntities, panelPostEntities);
        return panelContent;
    }
    
    private Component createPanelSurname(){
        labelSurname = new JLabel("Прізвище");
        labelSurname.setHorizontalAlignment(JLabel.RIGHT);
        textFieldSurname = new JTextField(textFieldSize);
        JPanel panelSurname = createLinePanel();
        panelSurname.add(labelSurname);
        panelSurname.add(Box.createHorizontalStrut(horizontalStrut));
        panelSurname.add(textFieldSurname);
        return panelSurname;
    }
    
    private Component createPanelName(){
        labelName = new JLabel("Ім'я");
        labelName.setHorizontalAlignment(JLabel.RIGHT);
        textFieldName = new JTextField(textFieldSize);
        JPanel panelName = createLinePanel();
        panelName.add(labelName);
        panelName.add(Box.createHorizontalStrut(horizontalStrut));
        panelName.add(textFieldName);
        return panelName;
    }
    
    private Component createPanelPatronymic(){
        labelPatronymic = new JLabel("По батькові");
        labelPatronymic.setHorizontalAlignment(JLabel.RIGHT);
        textFieldPatronymic = new JTextField(textFieldSize);
        JPanel panelPatronymic = createLinePanel();
        panelPatronymic.add(labelPatronymic);
        panelPatronymic.add(Box.createHorizontalStrut(horizontalStrut));
        panelPatronymic.add(textFieldPatronymic);
        return panelPatronymic;
    }
    
    private Component createPanelLogin(){
        labelLogin = new JLabel("Логін");
        labelLogin.setHorizontalAlignment(JLabel.RIGHT);
        textFieldLogin = new JTextField(textFieldSize);
        JPanel panelLolgin = createLinePanel();
        panelLolgin.add(labelLogin);
        panelLolgin.add(Box.createHorizontalStrut(horizontalStrut));
        panelLolgin.add(textFieldLogin);
        return panelLolgin;
    }
    
    private Component createPanelPassword(){
        labelPassword = new JLabel("Пароль");
        labelPassword.setHorizontalAlignment(JLabel.RIGHT);
        textFieldPassword = new JTextField(textFieldSize);
        buttonGenPass = new JButton("Генерувати");
        panelPass = createLinePanel();
        panelPass.add(textFieldPassword);
        panelPass.add(buttonGenPass);
        JPanel panelPassword = createLinePanel();
        panelPassword.add(labelPassword);
        panelPassword.add(Box.createHorizontalStrut(horizontalStrut));
        panelPassword.add(panelPass);
        return panelPassword;
    }
    
    private Component createPanelEmail(){
        labelEmail = new JLabel("Електронна пошта");
        labelEmail.setHorizontalAlignment(JLabel.RIGHT);
        textFieldEmail = new JTextField(textFieldSize);
        textFieldEmail.setEditable(false);
        JPanel panelEmail = createLinePanel();
        panelEmail.add(labelEmail);
        panelEmail.add(Box.createHorizontalStrut(horizontalStrut));
        panelEmail.add(textFieldEmail);
        return panelEmail;
    }
    
    private Component createPanelDepartment(){
        labelDepartment = new JLabel("Відділ");
        labelDepartment.setHorizontalAlignment(JLabel.RIGHT);
        comboBoxDepartment = new ComboBoxDepartment();
        buttonAddDepartment = new JButton("+");
        buttonAddDepartment.addActionListener(new ButtonAddDepartmentEmployeeActionLIstener(this));
        panelDeparmentEntities = createLinePanel();
        panelDeparmentEntities.add(comboBoxDepartment);
        panelDeparmentEntities.add(buttonAddDepartment);
        JPanel panelDepartment = createLinePanel();
        panelDepartment.add(labelDepartment);
        panelDepartment.add(Box.createHorizontalStrut(horizontalStrut));
        panelDepartment.add(panelDeparmentEntities);
        return panelDepartment;
    }
    
    private Component createPanelPost(){
        labelPost = new JLabel("Посада");
        labelPost.setHorizontalAlignment(JLabel.RIGHT);
        comboBoxPost = new ComboBoxPost();
        buttonAddPost = new JButton("+");
        buttonAddPost.addActionListener(new ButtonAddPostEmployeeActionListener(this));
        panelPostEntities = createLinePanel();
        panelPostEntities.add(comboBoxPost);
        panelPostEntities.add(buttonAddPost);
        JPanel panelPost = createLinePanel();
        panelPost.add(labelPost);
        panelPost.add(Box.createHorizontalStrut(horizontalStrut));
        panelPost.add(panelPostEntities);
        return panelPost;
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
    
    
    private JPanel createLinePanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        return panel;
    }

    public ComboBoxDepartment getComboBoxDEpartment() {
        return comboBoxDepartment;
    }
    
    public ComboBoxPost getComboBoxPost(){
        return comboBoxPost;
    }
}
