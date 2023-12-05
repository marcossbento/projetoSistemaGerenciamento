package service;

import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.JTextComponent;


public class FilterTableService {
    public void filtrar(TableRowSorter<TableModel> filter, JTextComponent campo){
        
        String filtro = campo.getText();
        if(filtro.isEmpty()) filter.setRowFilter(null);
        else filter.setRowFilter(RowFilter.regexFilter(filtro));
    }
}
