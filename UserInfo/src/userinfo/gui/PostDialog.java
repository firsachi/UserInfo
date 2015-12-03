package userinfo.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import userinfo.entities.Post;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import toolsgui.ResizeComponentsFrame;
import toolsgui.popmenu.PopMenuInsert;

/**
 * Created by firsov on 22.09.2015.
 */

public class PostDialog extends JDialog {

    private JLabel labelName;
    private JLabel labelUnique;

    private JTextField textFieldPostName;

    private JCheckBox checkBoxUnique;

    private final Post post;

    private boolean flagUpdate = false;

    public PostDialog(){
        post = new Post();
        configDialog();
    }
    
    private void configDialog(){
        setModal(true);
        setDefaultCloseOperation(PostDialog.DISPOSE_ON_CLOSE);
        add(contentPanel(), BorderLayout.CENTER);
        add(buttonPanel(), BorderLayout.SOUTH);
    }

    public void updatePost(int postID) {
        flagUpdate =true;
        textFieldPostName.setText(post.getPostName());
        checkBoxUnique.setSelected(post.getPostUnique());
    }

    private JPanel contentPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        labelName = new JLabel("Найменування:");
        textFieldPostName = new JTextField(25);

        panel.add(componentContentPanel(labelName, textFieldPostName));
        panel.add(Box.createVerticalStrut(6));

        labelUnique = new JLabel("Посада для однієї людини:");
        checkBoxUnique =new JCheckBox();
        panel.add(componentContentPanel(labelUnique, checkBoxUnique));
        ResizeComponentsFrame.sizeComponents(labelName, labelUnique);
        ResizeComponentsFrame.sizeComponents(textFieldPostName, checkBoxUnique);
        return panel;
    }

    private void popMenu(MouseEvent me) {
        PopMenuInsert popMenuInsert = new PopMenuInsert(textFieldPostName);
        popMenuInsert.show(textFieldPostName, me.getX(), me.getY());
    }

    private JPanel componentContentPanel(JLabel label, JComponent component){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(label);
        panel.add(Box.createHorizontalStrut(6));
        panel.add(component);
        return panel;
    }

    private JPanel buttonPanel() {
        JButton buttonOk = new JButton("Виконати");
        JButton buttonCancel = new JButton("Скасувати");
        JPanel panelGrid = new JPanel(new GridLayout(1,2,5,2));
        panelGrid.add(buttonOk);
        panelGrid.add(buttonCancel);
        JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelButton.add(panelGrid);
        return panelButton;
    }

    public Post getPost() {
        return post;
    }

}
