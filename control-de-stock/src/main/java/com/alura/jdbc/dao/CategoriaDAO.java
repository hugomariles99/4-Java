package com.alura.jdbc.dao;

import com.alura.jdbc.modelo.Categoria;
import com.alura.jdbc.modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    private Connection con;

    public CategoriaDAO(Connection con) {
        this.con = con;
    }

    public List<Categoria> listar() {
        List<Categoria> resultado = new ArrayList<>();

        try {
            final PreparedStatement statement = con.prepareStatement(
                    "SELECT ID, NOMBRE FROM CATEGORIA");

            final ResultSet resultSet = statement.executeQuery();
            try (statement) {
                while (resultSet.next()) {
                    var categoria = new Categoria(resultSet.getInt("ID"),
                            resultSet.getString("NOMBRE"));

                    resultado.add(categoria);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }

    public List<Categoria> listarConProductos() {
        List<Categoria> resultado = new ArrayList<>();

        try {
            final PreparedStatement statement = con.prepareStatement(
                    "SELECT C.ID, C.NOMBRE, P.ID, P.NOMBRE, P.CANTIDAD "
                    + "FROM CATEGORIA C "
                    + "INNER JOIN PRODUCTO P ON C.ID = P.CATEGORIA_ID");

            final ResultSet resultSet = statement.executeQuery();

            try (statement) {
                while (resultSet.next()) {

                    int categoriaId = resultSet.getInt("ID");
                    String categoriaNombre = resultSet.getString("NOMBRE");

                    var categoria = resultado.stream()
                            .filter(cat -> cat.getId().equals(categoriaId))
                            .findAny().orElseGet(() -> {
                                Categoria cat = new Categoria(
                                        categoriaId,
                                        categoriaNombre);

                                resultado.add(cat);

                                return cat;
                            });

                    Producto producto = new Producto(
                            resultSet.getInt("P.ID"),
                            resultSet.getString("P.NOMBRE"),
                            resultSet.getInt("P.CANTIDAD"));
                    
                    categoria.agregar(producto);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }
}
