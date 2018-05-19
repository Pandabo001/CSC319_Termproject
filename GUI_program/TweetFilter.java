import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TweetFilter {
  
    public static JTextField createRowFilter(JTable table) {
      
        RowSorter<? extends TableModel> rowSort = table.getRowSorter();
        if (rowSort == null) {
            table.setAutoCreateRowSorter(true);
            rowSort = table.getRowSorter();
        }

        TableRowSorter<? extends TableModel> tableSort =
                (rowSort instanceof TableRowSorter) ? (TableRowSorter<? extends TableModel>) rowSort : null;

        if (tableSort == null) {
            throw new RuntimeException("Cannot find appropriate rowSort: " + rowSort);
        }

        final JTextField textField = new JTextField(15);
        textField.getDocument().addDocumentListener(new DocumentListener() {
          
            @Override
            public void insertUpdate(DocumentEvent e) {
                update(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                update(e);
            }

            private void update(DocumentEvent e) {
                String text = textField.getText();
                if (text.trim().length() == 0) {
                    tableSort.setRowFilter(null);
                } else {
                    tableSort.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
        });

        return textField;
    }
}