/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinfo.gui;

import userinfo.gui.frameuser.UkreinianConfigUserInfo;
import userinfo.gui.frameuser.ConfigFrameUserInfo;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import userinfo.gui.frameuser.EnumNameModel;
import userinfo.gui.frameuser.tablemodel.FillTableModel;
import userinfo.gui.frameuser.tablemodel.TableModel;
import userinfo.gui.lisenters.ButtonAddActionListener;
import userinfo.gui.lisenters.ButtonDeleteActionListener;
import userinfo.gui.lisenters.ButtonUpdateActionListener;
import userinfo.gui.lisenters.ToggleButtonDepartmentActionListener;
import userinfo.gui.lisenters.ToggleButtonPostActionListener;
import userinfo.gui.lisenters.ToggleButtonUserActionListener;

/**
 *
 * @author firsov
 */
public class FrameUserInfo extends JFrame{
    
    private final int contentPanelBorderSize = 12;
    
    private final ConfigFrameUserInfo settings;
    private EnumNameModel nameModel;
    
    private JButton buttonAdd;
    private JButton buttonDelete;
    private JButton buttonUpdate;
    
    private TableModel tableModelFrame;
    private JTable tableFrame;
    
    private JToggleButton toggleButtonUser;
    private JToggleButton toggleButtonPost;
    private JToggleButton toggleButtonDepartment;

    public FrameUserInfo(){
        settings = new UkreinianConfigUserInfo();
        configFrame();
    }
    
    private void configFrame(){
        setDefaultCloseOperation(FrameUserInfo.DISPOSE_ON_CLOSE);
        add(createPanelContent(), BorderLayout.CENTER);
        add(createPanelButton(), BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createPanelContent() {
        JPanel panelContent = new JPanel();
        panelContent.setBorder(BorderFactory.createEmptyBorder(contentPanelBorderSize, contentPanelBorderSize, contentPanelBorderSize, contentPanelBorderSize));
        panelContent.setLayout(new BorderLayout());
        panelContent.add(createPanelMenuButton(), BorderLayout.NORTH);
        panelContent.add(createPanelTable(), BorderLayout.CENTER);
        return panelContent;
    }

    private JPanel createPanelMenuButton() {
        JPanel panelGrid = new JPanel();
        panelGrid.setLayout(new GridLayout(1, 0, 5, 2));
        panelGrid.add(createButtonAdd());
        panelGrid.add(createButtonDelete());
        panelGrid.add(createButtonUpdate());
        JPanel panelMenuButton = new JPanel();
        panelMenuButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelMenuButton.add(panelGrid);
        return panelMenuButton;
    }

    private JButton createButtonAdd() {
        buttonAdd = new JButton(settings.nameButtonAdd());
        buttonAdd.addActionListener(new ButtonAddActionListener(this));
        return buttonAdd;
    }

    private JButton createButtonDelete() {
        buttonDelete = new JButton(settings.nameButtonDelete());
        buttonDelete.addActionListener(new ButtonDeleteActionListener(this));
        return buttonDelete;
    }

    private JButton createButtonUpdate() {
        buttonUpdate = new JButton(settings.nameButtonUpdate());
        buttonUpdate.addActionListener(new ButtonUpdateActionListener(this));
        return buttonUpdate;
    }

    private JScrollPane createPanelTable() {
        nameModel = EnumNameModel.USER;
        tableModelFrame = new TableModel();
        FillTableModel fillTableModel = new FillTableModel();
        fillTableModel.fillTable(tableModelFrame, EnumNameModel.USER, false);
        tableFrame = new JTable(tableModelFrame);
        selectRowTable();
        JScrollPane scrollPaneTable = new JScrollPane(tableFrame);
        return scrollPaneTable;
    }

    private JPanel createPanelButton() {
        createToggleButtonUser();
        createToggleButtonPost();
        createToggleButtonDepartment();
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(toggleButtonUser);
        buttonGroup.add(toggleButtonPost);
        buttonGroup.add(toggleButtonDepartment);
        JPanel panelGroup = new JPanel();
        panelGroup.setLayout(new BoxLayout(panelGroup, BoxLayout.LINE_AXIS));
        panelGroup.add(toggleButtonUser);
        panelGroup.add(toggleButtonPost);
        panelGroup.add(toggleButtonDepartment);
        JPanel panelToggleButton = new JPanel();
        panelToggleButton.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelToggleButton.add(panelGroup);
        return panelToggleButton;
    }
    
    private void createToggleButtonUser(){
        toggleButtonUser = new JToggleButton(settings.nameToggleButtonUser());
        toggleButtonUser.setSelected(true);
        toggleButtonUser.addActionListener(new ToggleButtonUserActionListener(this));
        selectRowTable();
    }

    private void createToggleButtonPost() {
        toggleButtonPost = new JToggleButton(settings.nameToggleButtonPost());
        toggleButtonPost.addActionListener(new ToggleButtonPostActionListener(this));
        selectRowTable();
    }

    private void createToggleButtonDepartment() {
        toggleButtonDepartment = new JToggleButton(settings.nameToggleButtonDeaprtment());
        toggleButtonDepartment.addActionListener(new ToggleButtonDepartmentActionListener(this));
        selectRowTable();
    }

    public void selectRowTable() {
        if (tableModelFrame.getRowCount() > 0){
            tableFrame.setRowSelectionInterval(0, 0);
        }
    }

    public void setNameModel(EnumNameModel nameModel) {
        this.nameModel = nameModel;
    }
       
    public TableModel getTableModelFrame() {
        return tableModelFrame;
    }

    public EnumNameModel getNameModel() {
        return nameModel;
    }

    public JTable getTableFrame() {
        return tableFrame;
    }
    
}