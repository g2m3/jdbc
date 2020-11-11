import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Colecciones {
    static Connection con = null;

    public static void main(String[] args) {
        pruebaConexion();
        recuperarInfo();
    }
    
    private static void pruebaColecciones(){
        HashSet prueba = new HashSet(1000);
        prueba.add("Soy una cadena cualquiera");
        System.out.println(prueba.size());
        ArrayList<Object> exp = new ArrayList<>();
        exp.add("sdf");
        exp.add(55);
        prueba.add(88);
        
    }
    
    private static void pruebaConexion(){
        String MySQLURL = "jdbc:mysql://localhost:3306/astroluna?useSSL=false";
        String databseUserName = "root";
        String databasePassword = "12345";
        
        try {
           con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
           if (con != null) {
              System.out.println("Database connection is successful !!!!");
           }
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    
    private static void recuperarInfo(){
        ResultSet rs = null;
        try {
            Statement st = con.createStatement();
            String query = ("SELECT * FROM repetition ORDER BY id DESC LIMIT 1;");
            rs = st.executeQuery(query);
            if (rs.next()) {
               String fname = rs.getString("version");
               String lname = rs.getString("number");
               System.out.println("First:" + fname + " y " + lname);
               
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
