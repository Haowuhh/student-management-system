package com.ecut.service;

import com.ecut.model.Student;
import com.ecut.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;

public class StudentService {
    public static Connection connection;
    public static PreparedStatement preparedStatement;

    public static ArrayList<Student> SelectAll() throws SQLException {
        ArrayList<Student> arrayList = new ArrayList<>();
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from classtable";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                arrayList.add(new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            JDBCUtils.close(connection,preparedStatement);
           } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return arrayList;
    }

    public static boolean update(int id, String name, String gender) throws SQLException {
        try {
            connection = JDBCUtils.getConnection();
            String sql = "update classtable set name=?,gender=? where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,gender);
            preparedStatement.setInt(3,id);
            int res = preparedStatement.executeUpdate();
            if (res > 0) return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.close(connection,preparedStatement);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public static boolean delete(int id) throws SQLException {
        try {
            connection = JDBCUtils.getConnection();
            String sql = "delete from classtable where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            int res = preparedStatement.executeUpdate();
            if (res > 0) return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.close(connection,preparedStatement);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public static boolean insert(String name, String gender) throws SQLException {
        try {
            connection = JDBCUtils.getConnection();
            String sql = "insert into classtable values(null,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,gender);

            int res = preparedStatement.executeUpdate();
            if (res > 0) return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                JDBCUtils.close(connection,preparedStatement);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}
