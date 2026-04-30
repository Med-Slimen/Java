import java.sql.*;

public class Test {
    public static void main(String[] args) {
        Connection con =null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_personne","root","");
            /*
            PreparedStatement preparedStatement = con.prepareStatement("insert into personne values(default,?,?)");
            preparedStatement.setString(1,"Ayoub");
            preparedStatement.setString(2, "Fosdo9");
            preparedStatement.executeUpdate();
            System.out.println("Insertion avec succés!!");*/
            System.out.println("Affichage avant de supprimer");
            Statement st = con.createStatement();
            ResultSet resulat = st.executeQuery(" select * from personne");
            while(resulat.next())
            {
                String id = resulat.getString(1);
                String nom = resulat.getString(2);
                String prenom = resulat.getString(3);
                System.out.println("ID = " +id +" nom = " +nom +" prenom = "+prenom);

            }
            PreparedStatement ps = con.prepareStatement("delete from personne where ID_personne=?");
            ps.setString(1, "3");
            ps.executeUpdate();
            System.out.println(" succés de suppression!!");
            System.out.println("Affichage apres la supprimation");
            resulat = st.executeQuery(" select * from personne");
            while(resulat.next())
            {
                String id = resulat.getString(1);
                String nom = resulat.getString(2);
                String prenom = resulat.getString(3);
                System.out.println("ID = " +id +" nom = " +nom +" prenom = "+prenom);

            }
        }
        catch (Exception e)
        {
            System.out.println("Echec !!");
            e.printStackTrace();
        }
        if (con!=null)
            System.out.println("Succés!!");
        else
            System.out.println("Echec !!");

    }

}
