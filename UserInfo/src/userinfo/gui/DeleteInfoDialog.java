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
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import toolsgui.ConfigComponentsGUI;
import toolsgui.UkrainianNameButton;
import userinfo.gui.delete.DeleteRow;
import userinfo.gui.lisenters.ButtonCanselActionListener;

/**
 *
 * @author firsov
 */
public class DeleteInfoDialog extends JDialog{
    
    private final int id;
    private boolean resolveRemove = false;
    private final DeleteRow deleteRow;
    private JLabel labelInfo;
    private JButton buttonOk;
    private JButton buttonCansel;
    private final ConfigComponentsGUI configComponent = new UkrainianNameButton();

    public DeleteInfoDialog(int id, DeleteRow deleteRow) {
        this.id = id;
        this.deleteRow = deleteRow;
        configDeleteDialog();
    }
    
    private void configDeleteDialog(){
        setModal(true);
        setTitle("Видалит рядок.");
        Component createContentPanel;
        add(createContentPanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private JPanel createContentPanel() {
        labelInfo = new JLabel("Ви дійсно бажаєте видалити запис.");
        JPanel panelContent = new JPanel();
        panelContent.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelContent.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        panelContent.add(labelInfo);
        return panelContent;
    }

    private Component createButtonPanel() {
        JPanel panelGrid = new JPanel();
        panelGrid.setLayout(new GridLayout(1, 0, 5, 2));
        panelGrid.add(createButtonOk());
        panelGrid.add(createButtonCansel());
        JPanel panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelButton.add(panelGrid);
        return panelButton;
    }

    private JButton createButtonOk() {
        buttonOk = new JButton(configComponent.nameButtonOk());
        deleteRow.setDeleteInfoDialog(this);
        buttonOk.addActionListener(deleteRow);
       // buttonOk.addActionListener(new DeleteDialogButtonOkActionListenet(this));
        return buttonOk;
    }

    private JButton createButtonCansel() {
        buttonCansel = new JButton(configComponent.nameButtonCansel());
        buttonCansel.addActionListener(new ButtonCanselActionListener(this));
        return buttonCansel;
    }
    
    public void setResolveRemove(boolean resolveRemove) {
        this.resolveRemove = resolveRemove;
    }
   
    public JLabel getLabelInfo() {
        return labelInfo;
    }

    public int getId() {
        return id;
    }

    public boolean getResolveRemove() {
        return resolveRemove;
    }
}
