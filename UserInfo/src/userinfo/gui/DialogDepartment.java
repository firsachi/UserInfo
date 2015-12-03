/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui;

import userinfo.gui.lisenters.ButtonCanselActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import toolsgui.ConfigComponentsGUI;
import toolsgui.UkrainianNameButton;

/**
 *
 * @author firsov
 */
public class DialogDepartment extends JDialog{
    
    private JLabel labelName;
    private JTextField textFieldNameDepartment;
    
    private final ConfigComponentsGUI configComponent;
    private final int borderSize = 12;
    
    private JButton buttonOk;
    private JButton buttonCansel;
    
    public DialogDepartment() {
        configComponent = new UkrainianNameButton();
        configDialog();
    }
    
    private void configDialog(){
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);
        add(createContentPanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private JPanel createContentPanel() {
        labelName = new JLabel("Найменування:");
        textFieldNameDepartment = new JTextField(configComponent.sizeTextField());
        JPanel panelComponent = new JPanel();
        panelComponent.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSize, borderSize));
        panelComponent.add(labelName);
        panelComponent.add(textFieldNameDepartment);
        return panelComponent;
    }

    private JPanel createButtonPanel() {
        JPanel panelGrid = new JPanel();
        panelGrid.setLayout(new  GridLayout(1,0,5,2));
        panelGrid.add(createButtonOk());
        panelGrid.add(createButtonCansel());
        JPanel panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelButton.add(panelGrid);
        return panelButton;
    }

    private JButton createButtonOk() {
        buttonOk = new JButton(configComponent.nameButtonOk());
        return buttonOk;
    }

    private JButton createButtonCansel() {
        buttonCansel = new JButton(configComponent.nameButtonCansel());
        buttonCansel.addActionListener(new ButtonCanselActionListener((JDialog) this));
        return buttonCansel;
    }
    
}
