package database_Mail;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Alfred Espinosa
 */
public class SqlConnection {
    // JDBC driver name and database URL

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    //private static final String DB_URL = "jdbc:mysql://localhost/photobooth";
    private static final String DB_URL = "jdbc:mysql://185.177.59.153:3306/fys";
    //Database credentials
    private static final String USER = "root";
    //private static final String PASS = "";
    private static final String PASS = "fys-resort5";

    //Database connection and Statement
    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;
    private static int sessionID = 0;
    private static final String YEARTOREMOVE = currentDateTime();

    public void Open() throws SQLException, ClassNotFoundException {

        //STEP 2: Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        //STEP 3: Open a connection
        System.out.println("Connecting to a selected database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Connected database successfully...");

        System.out.println("Connection Established!\n");
    }

    public void Close() throws SQLException{

        if (stmt != null) {
            conn.close();
        }
        if (conn != null) {
            conn.close();
        }
        System.out.println("Connection Closed");
    }

    public void Insert(String generatedCode, String curDate, String[] listFotos, int aantalFotos, int temp) throws SQLException{

        //STEP 4: Execute a query
        System.out.println("Inserting records into the table...");
        stmt = conn.createStatement();

        String sql = "INSERT INTO sessie (code, locatie, temperatuur, aantal, tijd) "
                + "VALUES ('" + generatedCode + "','Amsterdam','"+temp+"','" + aantalFotos + "','" + curDate + "')";
        stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        rs = stmt.getGeneratedKeys();

        while (rs.next()) {
            sessionID = rs.getInt(1);
            // Get automatically generated key 
            // value
            System.out.println("automatically generated key value = " + sessionID);
        }

        for (int i = 0; i < aantalFotos; i++) {
            insertFoto(sessionID, listFotos[i]);
        }
        

        System.out.println("Inserted records into the table...");

    }//end main

    public void Remove() throws SQLException{

        //STEP 4: Execute a query
        System.out.println("Removing records older than one year");
        stmt = conn.createStatement();

        String sql = "DELETE FROM sessie WHERE tijd < '" + YEARTOREMOVE + "'";
        stmt.executeUpdate(sql);

        System.out.println("Records removed from the table\n");

    }//end main

    private String insertFoto(int last_id, String file) throws SQLException{
        String sql = "INSERT INTO foto (sessieID, path) VALUES ('" + last_id + "','images/" + file + "')";
        stmt.executeUpdate(sql);
        return "new record added sessie";
    }

    private static String currentDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now().minusYears(1);

        return dtf.format(now);
    }
}
