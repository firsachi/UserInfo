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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import toolsgui.ConfigComponentsGUI;
import toolsgui.UkrainianNameButton;
import userinfo.entities.EnumAction;
import userinfo.entities.Post;
import userinfo.gui.lisenters.ButtonCanselActionListener;
import userinfo.gui.post.PostButttonOkActionListener;

/**
 *
 * @author firsov
 */
public class DialogPost extends JDialog{
    
    private EnumAction action = EnumAction.INSERT;
    private JLabel labelError;
    private JLabel labelName;
    private JLabel labelUnique;

    private JTextField textFieldPostName;
    private final int textFieldSize = 20;

    private JCheckBox checkBoxUnique;

    private Post post;
    private final int borderSize = 12;
    private final int borderSizeNull = 0;
    
    private JButton buttonOk;
    private JButton buttonCansel;
    private final ConfigComponentsGUI nameButton = new UkrainianNameButton();

    public DialogPost() {
        post = new Post();
        configDialog();
    }

    private void configDialog() {
        setModal(true);
        setDefaultCloseOperation(DialogPost.DISPOSE_ON_CLOSE);
        add(creatErrorPanel(), BorderLayout.NORTH);
        add(creteContentPanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
    }
    
    @Override
    public void setTitle(String title){
        super.setTitle(title);
    }

    private JPanel creatErrorPanel(){
        labelError = new JLabel(" ");
        JPanel panelError = new JPanel();
        panelError.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelError.setBorder(BorderFactory.createEmptyBorder(borderSize, borderSize, borderSizeNull, borderSize));
        panelError.add(labelError);
        return panelError;
    }
    
    private JPanel creteContentPanel() {
        JPanel panelContent = new JPanel();
        panelContent.setLayout(new GridLayout(2, 2, 6, 6));
        panelContent.setBorder(BorderFactory.createEmptyBorder(borderSizeNull, borderSize, borderSize, borderSize));
        
        labelName = new JLabel("Найменування:");
        panelContent.add(labelName);
        
        textFieldPostName = new JTextField(textFieldSize);
        panelContent.add(textFieldPostName);
        
        labelUnique = new JLabel("Посада для однієї людини:");
        panelContent.add(labelUnique);
        
        checkBoxUnique = new JCheckBox();
        panelContent.add(checkBoxUnique);
        
        return panelContent;
    }

    private JPanel createButtonPanel() {
        JPanel panelGrid = new JPanel();
        panelGrid.setLayout(new GridLayout(1, 2, 5, 5));
        
        buttonOk = new JButton(nameButton.nameButtonOk());
        buttonOk.addActionListener(new PostButttonOkActionListener(this));
        panelGrid.add(buttonOk);
        
        buttonCansel = new JButton(nameButton.nameButtonCansel());
        buttonCansel.addActionListener(new ButtonCanselActionListener(this));
        panelGrid.add(buttonCansel);
        
        JPanel panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelButton.setBorder(BorderFactory.createEmptyBorder(borderSizeNull, borderSize, borderSize, borderSize));
        panelButton.add(panelGrid);
        return panelButton;
    }
    
    public void setPost(Post post){
        this.post = post;
        textFieldPostName.setText(post.getPostName());
        checkBoxUnique.setSelected(post.getPostUnique());
        action = EnumAction.UPDATE;
    }
    
    public String getTextNamePost(){
        return textFieldPostName.getText().trim();
    }
    
    public boolean getUniquePost(){
        return checkBoxUnique.isSelected();
    }

    public  EnumAction getAction(){
        return action;
    }

    public JLabel getLabelName() {
        return labelName;
    }

    public Post getPost() {
        post.setPostName(textFieldPostName.getText().trim());
        post.setPostUnique(checkBoxUnique.isSelected());
        return this.post;
    }

    public JLabel getLabelError() {
        return labelError;
    }
    
    
}
