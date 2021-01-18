package zoznam_tel_cisel;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author bluna
 */
public class CisloClass {
    private String Meno;
    private String Priezvisko;
    private String Cislo;
    
    public void setMeno(String a)
    {
        Meno = a;
    }
    public void setPriezvisko(String a)
    {
        Priezvisko = a;
    }
    public void setCislo(String a)
    {
        Cislo = a;
    }
    public String getMeno()
    {
        return Meno;
    }
    public String getPriezvisko()
    {
        return Priezvisko;
    }
    public String getCislo()
    {
        return Cislo;
    }
    
    public void ZapisDoDB()
    {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/tel_cisla";
            String user = "root";
            String password = "";
            
            conn = (Connection) DriverManager.getConnection(url, user, password);
            
            
            String sql = "INSERT INTO zoznam(Meno, Priezvisko, Cislo) VALUES(?,?,?)";
            
            PreparedStatement DataInsert = conn.prepareStatement(sql);
            
                DataInsert.setString(1, this.Meno);
                DataInsert.setString(2, this.Priezvisko);
                DataInsert.setString(3, this.Cislo);
                DataInsert.executeUpdate();
  
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("error");
        }finally{
            try{
                if(conn != null)
                    conn.close();
            }
            catch(SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
            System.out.println("ukoncene");
        }
        
    }
   
}
