package com.example.dao.impl;

import com.example.dao.GenericDAO;
import com.example.mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractDAO<T> implements GenericDAO<T> {

    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String sqlHostName = "LAPTOP-QQM98R2J";
            String sqlInstanceName = "S1MPLEASIA";
            String sqlDatabase = "cnpm";

            String dbURL = "jdbc:sqlserver://" + sqlHostName + ":1433" + ";instance=" + sqlInstanceName + ";databaseName=" +
                    sqlDatabase + ";encrypt=true;trustServerCertificate=true;";

            String username = "sa";
            String password = "duong1807";

            return DriverManager.getConnection(dbURL, username, password);


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<T> query(String sql, RowMapper<T> rowMapper, Object... params) {
        List<T> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;


        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            setParameter(statement, params);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                results.add(rowMapper.mapRow(resultSet));
            }

            return results;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null) {
                    connection.close();
                }

                if(statement != null) {
                    statement.close();
                }

                if(resultSet != null) {
                    resultSet.close();
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    public void setParameter(PreparedStatement statement, Object... params) {
        try {
            for(int i = 0;i < params.length; i++) {
                Object parameter = params[i];
                int index = i + 1;
                if(parameter instanceof Long) {
                    statement.setLong(index, (Long) parameter);
                }

                else if(parameter instanceof String) {
                    statement.setString(index, (String) parameter);
                }

                else if(parameter instanceof Integer) {
                    statement.setInt(index, (Integer) parameter);
                }

                else if(parameter instanceof Date) {
                    statement.setDate(index, (Date) parameter);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
