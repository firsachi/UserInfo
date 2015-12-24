/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui;

import userinfo.gui.lisenters.ButtonCanselActionListener;
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
import userinfo.entities.Department;
import userinfo.entities.EnumAction;
import userinfo.gui.department.DialogDepartmentButtonOkActionListener;

/**
 *
 * @author firsov
 */
public class DialogDepartment extends JDialog{
    
    private Department department;
    private EnumAction action = EnumAction.INSERT;
    
    private JLabel labelError;
    private JLabel labelName;
    private JTextField textFieldNameDepartment;
    
    private final ConfigComponentsGUI configComponent;
    private final int borderSize = 12;
    private final int horizontalStrut = 6;
    
    private JButton buttonOk;
    private JButton buttonCansel;
    
    public DialogDepartment(String title) {
        super.setTitle(title);
        department = new Department();
        configComponent = new UkrainianNameButton();
        configDialog();
    }
    
    private void configDialog(){
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);
        add(createPanelError(), BorderLayout.NORTH);
        add(createContentPanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
    }

    private JPanel createPanelError(){
        labelError = new JLabel(" ");
        JPanel panelError = new JPanel();
        panelError.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelError.add(labelError);
        return panelError;
    }
    
    private JPanel createContentPanel() {
        JPanel panelComponent = new JPanel();
        panelComponent.setLayout(new BoxLayout(panelComponent, BoxLayout.PAGE_AXIS));
        panelComponent.setBorder(BorderFactory.createEmptyBorder(0, borderSize, borderSize, borderSize));
        panelComponent.add(createPanelName());
        ResizeComponentsFrame resizeComponentsFrame = new ResizeComponentsFrame();
        resizeComponentsFrame.sizeComponents(labelName);
        resizeComponentsFrame.sizeComponents(textFieldNameDepartment);
        return panelComponent;
    }
    
    private Component createPanelName(){
        labelName = new JLabel("Найменування:");
        labelName.setHorizontalAlignment(JLabel.RIGHT);
        
        textFieldNameDepartment = new JTextField(configComponent.sizeTextField());
        textFieldNameDepartment.addKeyListener(new TextFiledKeyboardLisenter(this));
        
        JPanel panelName = new JPanel();
        panelName.setLayout(new BoxLayout(panelName, BoxLayout.LINE_AXIS));
        panelName.add(labelName);
        panelName.add(Box.createHorizontalStrut(horizontalStrut));
        panelName.add(textFieldNameDepartment);
        return panelName;
    }
    
    private JPanel createButtonPanel() {
        JPanel panelGrid = new JPanel();
        panelGrid.setLayout(new  GridLayout(1,0,5,2));
        panelGrid.add(createButtonOk());
        panelGrid.add(createButtonCansel());
        JPanel panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelButton.setBorder(BorderFactory.createEmptyBorder(0, borderSize, borderSize, borderSize));
        panelButton.add(panelGrid);
        return panelButton;
    }

    private JButton createButtonOk() {
        buttonOk = new JButton(configComponent.nameButtonOk());
        buttonOk.addActionListener(new DialogDepartmentButtonOkActionListener(this));
        return buttonOk;
    }

    private JButton createButtonCansel() {
        buttonCansel = new JButton(configComponent.nameButtonCansel());
        buttonCansel.addActionListener(new ButtonCanselActionListener((JDialog) this));
        department = null;
        return buttonCansel;
    }

    public String getTextFieldNameDepartment() {
        return textFieldNameDepartment.getText().trim();
    }

    public JLabel getLabelName() {
        return labelName;
    }

    public JLabel getLabelError() {
        return labelError;
    }

    public void setDepartment(Department department) {
        this.department = department;
        textFieldNameDepartment.setText(department.getDepartmentName());
        action = EnumAction.UPDATE;
    }
    
    public Department getDepartment() {
        return department;
    }

    public EnumAction getAction() {
        return action;
    }
    
    
}
