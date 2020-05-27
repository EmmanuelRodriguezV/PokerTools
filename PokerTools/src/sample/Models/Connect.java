package sample.Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Connect {
    ArrayList<RowsCards>cartas = new ArrayList<>();

    public  int getOpenRaiseValue(String carta) {

        String sql2 = "SELECT OpenRaise from Cardestates";
        String sql = "SELECT OpenRaise from Cardestates where Carta = '"+carta +"'";
        int valor = 0;
        try {
            Connection conn = this.connect();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);


                System.out.println(rs.toString());
               valor = rs.getInt("OpenRaise");

        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return  valor;
    }

    private Connection connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite:/home/mybox/Downloads/untitled folder/SQLiteStudio/Pokerstates";
        String url = "jdbc:sqlite:src/Database/Pokerstates";
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(url);
            System.out.println("conexion establecida");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * select all rows in the warehouses table
     */
    public ArrayList<RowsCards> selectAll(){
        String sql = "SELECT Carta FROM Cardestates";
        ArrayList<RowsCards> Cartas_enteras = new ArrayList<>();
        RowsCards row ;
        row = new RowsCards();

        ArrayList<String> cartas = new ArrayList<>();
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            // loop through the result set

            int iterador = 1;
            while (rs.next()) {

                cartas.add(rs.getString("Carta"));
                switch (iterador)
                {
                    case 1:
                        row.setC1(rs.getString("Carta"));
                        iterador++;
                //        System.out.println(rs.getString("Carta"));
                        break;
                    case 2:
                        row.setC2(rs.getString("Carta"));
                        iterador++;
                        break;
                    case 3:
                        row.setC3(rs.getString("Carta"));
                        iterador++;
                        break;
                    case 4:
                        row.setC4(rs.getString("Carta"));
                        iterador++;
                        break;
                    case 5:
                        row.setC5(rs.getString("Carta"));
                        iterador++;
                        break;
                    case 6:
                        row.setC6(rs.getString("Carta"));
                        iterador++;
                        break;
                    case 7:
                        row.setC7(rs.getString("Carta"));
                        iterador++;
                        break;
                    case 8:
                        row.setC8(rs.getString("Carta"));
                        iterador++;
                        break;
                    case 9:
                        row.setC9(rs.getString("Carta"));
                        iterador++;
                        break;
                    case 10:
                        row.setC10(rs.getString("Carta"));
                        iterador++;
                        break;
                    case 11:
                        row.setC11(rs.getString("Carta"));
                        iterador++;
                        break;
                    case 12:
                        row.setC12(rs.getString("Carta"));
                        iterador++;
                        break;
                    case 13:

                        row.setC13(rs.getString("Carta"));
                        iterador = 1;
                        Cartas_enteras.add(row);
                        row = new RowsCards();
                        break;
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Cartas_enteras.add(row);

        return  Cartas_enteras;
    }
}
