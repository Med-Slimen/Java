package com.slimene.demo5;




import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlantDAO {

    private Connection conn;

    public PlantDAO() {
        conn = DatabaseConnection.getConnection();
    }

    // ✅ CREATE
    public void addPlant(Plant plant) {
        String query = "INSERT INTO plant(name, species) VALUES (?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, plant.getName());
            ps.setString(2, plant.getSpecies());
            ps.executeUpdate();
            System.out.println("✅ Plant added");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ READ ALL
    public List<Plant> getAllPlants() {
        List<Plant> plants = new ArrayList<>();
        String query = "SELECT * FROM plant";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                plants.add(new Plant(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("species")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return plants;
    }

    // ✅ UPDATE
    public void updatePlant(Plant plant) {
        String query = "UPDATE plant SET name=?, species=? WHERE id=?";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, plant.getName());
            ps.setString(2, plant.getSpecies());
            ps.setInt(3, plant.getId());
            ps.executeUpdate();
            System.out.println("✅ Plant updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ DELETE
    public void deletePlant(int id) {
        String query = "DELETE FROM plant WHERE id=?";

        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("🗑️ Plant deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
