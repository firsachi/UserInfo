package userinfo.gui.frameuser.tablemodel;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import userinfo.entities.RowEntities;

public class TableModel extends DefaultTableModel {

    public TableModel(){
        
    }

    @Override
    public boolean isCellEditable(int row, int column){
        return false;
    }

    public void updateRow(int numberRow, Object[] dataObject){
        for (int index=0; dataObject.length > index; index++){
            setValueAt(dataObject[index], numberRow, index);
        }
    }
    
    public void clearTableModel(){
        TableModel.this.setColumnCount(0);
        while (TableModel.this.getRowCount() > 0){
            TableModel.this.removeRow(0);
        }
    }

    public void addNameColumn(NameColumn nameColumn){
        setColumnCount(0);
        for (String name : nameColumn.getNAmeColumn()){
            addColumn(name);
        }
    }

    public void fillTableModel(ArrayList<RowEntities> arrayList){
        for (RowEntities rowData : arrayList){
            addRow(rowData.getRow());
        }
    }
}
