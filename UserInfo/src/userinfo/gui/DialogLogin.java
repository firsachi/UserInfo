/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import toolsgui.ConfigComponentsGUI;
import toolsgui.ResizeComponentsFrame;
import toolsgui.UkrainianNameButton;
import userinfo.gui.lisenters.ButtonCanselActionListener;
import userinfo.gui.lisenters.LoginDialogButtonOkActionListener;

/**
 *
 * @author firsov
 */
public class DialogLogin extends JDialog{
    
    private JLabel labelLogin;
    private JLabel labelPassword;
    
    private JTextField textFieldLogin;
    private JTextField textFieldPassword;
    
    private final ConfigComponentsGUI configComponents;
    private final int horizontalStrut = 6;
    private final int verticalStrut = 6;
    private final int bordersSizeContentPanel = 12;
    
    private JButton buttonOk;
    private JButton buttonCansel;

    public DialogLogin() {
        configComponents = new UkrainianNameButton();
        createConfigDialog();
    }
    
    private void createConfigDialog(){
        String title = "Вхід до системи.";
        setTitle(title);
        setDefaultCloseOperation(DialogLogin.DISPOSE_ON_CLOSE);
        add(cretaeContentPanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private JPanel cretaeContentPanel() {
        JPanel panelContent = new JPanel();
        panelContent.setLayout(new BoxLayout(panelContent, BoxLayout.PAGE_AXIS));
        panelContent.setBorder(BorderFactory.createEmptyBorder(bordersSizeContentPanel, bordersSizeContentPanel, bordersSizeContentPanel, bordersSizeContentPanel));
        panelContent.add(panelLogin());
        panelContent.add(Box.createVerticalStrut(verticalStrut));
        panelContent.add(panelPassword());
        ResizeComponentsFrame resizeComponentsFrame = new ResizeComponentsFrame();
        ResizeComponentsFrame.sizeComponents(labelLogin,labelPassword);
        return panelContent;
    }

    private JPanel panelLogin() {
        String textLabel = "Логін:";
        labelLogin = new JLabel(textLabel);
        textFieldLogin = new JTextField(configComponents.sizeTextField());
        JPanel panelLogin = new JPanel();
        panelLogin.setLayout(new BoxLayout(panelLogin, BoxLayout.LINE_AXIS));
        panelLogin.add(labelLogin);
        panelLogin.add(Box.createHorizontalStrut(horizontalStrut));
        panelLogin.add(textFieldLogin);
        return panelLogin;
    }

    private JPanel panelPassword() {
        String textLabel = "Пароль:";
        labelPassword = new JLabel(textLabel);
        textFieldPassword = new JPasswordField(configComponents.sizeTextField());
        JPanel panelPassword = new JPanel();
        panelPassword.setLayout(new BoxLayout(panelPassword, BoxLayout.LINE_AXIS));
        panelPassword.add(labelPassword);
        panelPassword.add(Box.createHorizontalStrut(horizontalStrut));
        panelPassword.add(textFieldPassword);
        return panelPassword;
    }

    private JPanel createButtonPanel() {
        JPanel panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelButton.add(createGridPanel());
        return panelButton;
    }

    private JPanel createGridPanel() {
        createButtonOK();
        createButtonCansel();
        JPanel panelGrid = new JPanel();
        panelGrid.setLayout(new GridLayout(1, 2, 5, 2));
        panelGrid.add(buttonOk);
        panelGrid.add(buttonCansel);
        return panelGrid;
    }

    private void createButtonOK() {
        buttonOk = new JButton(configComponents.nameButtonOk());
        buttonOk.addActionListener(new LoginDialogButtonOkActionListener(this));
    }

    private void createButtonCansel() {
        buttonCansel = new JButton(configComponents.nameButtonCansel());
        buttonCansel.addActionListener(new ButtonCanselActionListener((JDialog) this));
    }
}