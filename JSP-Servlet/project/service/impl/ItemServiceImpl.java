package item.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import item.model.Item;
import item.service.itemserv;

public class ItemServiceImpl implements itemserv {

    private DataSource dataSource;
    private List<Item> items = new ArrayList<>();

    public ItemServiceImpl() {}

    public ItemServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // -------------------- GET ALL --------------------
    @Override
    public List<Item> getItems() {

        if (dataSource != null) {
            try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM ITEM ORDER BY id")
            ) {
                items.clear();

                while (rs.next()) {
                    items.add(new Item(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getDouble("price")  
                    ));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return new ArrayList<>(items);
    }

    // -------------------- GET ONE --------------------
    @Override
    public Item getItem(Long id) {

        if (dataSource != null) {
            try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM ITEM WHERE id=" + id)
            ) {
                if (rs.next()) {
                    return new Item(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getDouble("price")  
                    );
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    // -------------------- CREATE --------------------
    @Override
    public void createItem(Item item) {

        if (item.getName() == null || item.getName().trim().isEmpty())
            throw new IllegalArgumentException("name required");

        if (item.getPrice() <= 0)
            throw new IllegalArgumentException("price must be > 0");

        if (dataSource != null) {
            try (Connection connection = dataSource.getConnection();
                 Statement statement = connection.createStatement()) {

                statement.executeUpdate(
                    "INSERT INTO ITEM (name,price) VALUES ('"
                    + item.getName() + "',"
                    + item.getPrice() + ")"
                );

            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    // -------------------- UPDATE --------------------
    @Override
    public void updateItem(Item item) {

        if (item.getId() == null)
            throw new IllegalArgumentException("ID required");

        if (dataSource != null) {
            try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement()
            ) {

                String sql = "UPDATE ITEM SET name='"
                		+ item.getName()
                        + "', price=" + item.getPrice()
                        + " WHERE id=" + item.getId();

                statement.executeUpdate(sql);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // -------------------- DELETE --------------------
    @Override
    public void removeItem(Long id) {

        if (dataSource != null) {
            try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement()
            ) {
                statement.executeUpdate("DELETE FROM ITEM WHERE id=" + id);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}