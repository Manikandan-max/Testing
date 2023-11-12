package base;

import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class SQLDataBaseConnection {
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/logintest";
    private static final String USERNAME="root";
    private static final String PASSWORD="Admin01@";
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    public static Object[][] getLoginTestDataFromDatabase() throws SQLException {
        try (Connection connection = connect()) {
            String sql = "SELECT username, password, comments, pageTitle FROM login_data";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                List<Hashtable<String, String>> data = new ArrayList<>();
                while (resultSet.next()) {
                    Hashtable<String, String> rowData = new Hashtable<>();
                    rowData.put("username", resultSet.getString("username"));
                    rowData.put("password", resultSet.getString("password"));
                    rowData.put("comments", resultSet.getString("comments"));
                    rowData.put("pageTitle", resultSet.getString("pageTitle"));
                    data.add(rowData);
                }
                // Convert List<Hashtable> to Object[][]
                Object[][] dataArray = new Object[data.size()][];
                for (int i = 0; i < data.size(); i++) {
                    dataArray[i] = new Object[]{data.get(i)};
                }

                return dataArray;
            }
        }
    }
}
