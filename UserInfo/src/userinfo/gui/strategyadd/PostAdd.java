package userinfo.gui.strategyadd;

import userinfo.entities.RowEntities;
import userinfo.gui.DialogPost;

/**
 * Created by firsov on 05.10.2015.
 */

public class PostAdd implements ButtonAddStartegy {
    
    private RowEntities rowEntities;

    @Override
    public RowEntities add() {
        DialogPost dialogPost = new DialogPost();
        dialogPost.setTitle("Новий відділ.");
        dialogPost.pack();
        dialogPost.setLocationRelativeTo(null);
        dialogPost.setResizable(false);
        dialogPost.setVisible(true);
        rowEntities = dialogPost.getPost();
        return rowEntities;
    }

}
