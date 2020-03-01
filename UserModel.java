import java.util.*;
import javax.swing.table.AbstractTableModel;
public class UserModel extends AbstractTableModel       
{
    private ArrayList<User> users = new ArrayList<>();
    private final String[] COLUMN_NAMES = {"usrname","age","email","passwd","phoneno"};
    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return users.get(rowIndex).getUsrname();
            case 1:
                return users.get(rowIndex).getAge();
            case 2:
                return users.get(rowIndex).getEmail();
            case 3:
                return users.get(rowIndex).getPasswd();
            case 4:
                return users.get(rowIndex).getPhoneno();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return COLUMN_NAMES[columnIndex];
    }
    
    User getUser(int rowIndex){
        return users.get(rowIndex);
    } 
    
    void databaseUpdated(){
       users = UserDB.getAll();
       fireTableDataChanged();
    }
}
