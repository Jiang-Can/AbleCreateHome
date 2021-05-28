package com.HospitalManage.model;

import com.HospitalManage.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseModel {

    private final QueryRunner queryRunner = new QueryRunner();

    public int update(String sql, Object... args) {
        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }
        return -1;
    }

    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection con = JDBCUtils.getConnection();
        try {
            return queryRunner.query(con, sql, new BeanHandler<>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con);
        }
        return null;
    }

    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection con = JDBCUtils.getConnection();
        try {
            return queryRunner.query(con, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con);
        }
        return null;
    }

    public <T> List<T> queryAllForList(Class<T> type, String sql) {
        Connection con = JDBCUtils.getConnection();
        try {
            return queryRunner.query(con, sql, new BeanListHandler<T>(type));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con);
        }
        return null;
    }

    public Object queryForSingleValue(String sql, Object... args){

        Connection conn = JDBCUtils.getConnection();

        try {
            return queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }
        return null;

    }

    public Object queryForSingleValue(String sql){

        Connection conn = JDBCUtils.getConnection();

        try {
            return queryRunner.query(conn, sql, new ScalarHandler());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(conn);
        }
        return null;

    }

}
