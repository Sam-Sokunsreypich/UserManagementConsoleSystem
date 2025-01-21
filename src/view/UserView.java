package view;

import model.User;
import java.util.List;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

public class UserView {
    public void displayTable(List<User> users, int page,int pageSize){
        String[] columnNames ={"ID","UUID","Name","Email","IsDelected"};
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        // Add column headers and set styles
        for (int i = 0; i < columnNames.length; i++) {
            table.addCell(columnNames[i], new CellStyle(CellStyle.HorizontalAlign.center));
            table.setColumnWidth(i, 30, 40); // Set column widths with a minimum and maximum range
        }

        // Add user data to the table
        for (User user : users) {
            table.addCell(String.valueOf(user.getId()), new CellStyle(CellStyle.HorizontalAlign.center));
            table.addCell(user.getUuid().toString(), new CellStyle(CellStyle.HorizontalAlign.center));
            table.addCell(user.getName(), new CellStyle(CellStyle.HorizontalAlign.center));
            table.addCell(user.getEmail(), new CellStyle(CellStyle.HorizontalAlign.center));
            table.addCell(String.valueOf(user.isDeleted()), new CellStyle(CellStyle.HorizontalAlign.center));
        }

        System.out.println(table.render());
        System.out.printf("Page %d%n",page);
    }
    public void displayMessage(String message){
        System.out.println(message);

    }
}
