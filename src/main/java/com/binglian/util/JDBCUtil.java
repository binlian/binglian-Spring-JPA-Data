package com.binglian.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC�����ࣺ
 * 1�� ��ȡConnection
 * 2�� �ͷ���Դ
 */
public class JDBCUtil {


    /**
     * ��ȡConnection
     * @return ����õ���JDBC��Connection
     */
    public static Connection getConnection() throws Exception {

        /**
         * �������Ұ�����Ӳ���뵽������
         *
         * ���ʵ���������ԵĽ���д�������ļ���
         */
//        String url = "jdbc:mysql:///spring_data";
//        String user = "root";
//        String password = "root";
//        String driverClass = "com.mysql.jdbc.Driver";

        InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);


        String url = properties.getProperty("jdbc.url");
        String user = properties.getProperty("jdbc.user");
        String password = properties.getProperty("jdbc.password");
        String driverClass = properties.getProperty("jdbc.driverClass");

        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    /**
     * �ͷ�DB��ص���Դ
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void release(ResultSet resultSet,
                               Statement statement, Connection connection){

        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }



}
