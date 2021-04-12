package com.m.dao.impl;

import com.m.dao.BooksDao;
import com.m.dao.base.BaseDao;
import com.m.entity.Books;
import com.m.entity.Page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BooksDaoImpl extends BaseDao implements BooksDao {
    @Override
    public int insert(Books books) {
        Connection conn = null;
        try {
            conn = super.getConnection();
            // 开启事务
            conn.setAutoCommit(false);

            // 组装sql
            String sql = "INSERT INTO books (`name`, `author`) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, books.getName());
            ps.setString(2, books.getAuthor());

            int r = ps.executeUpdate();

            // 提交事务
            conn.commit();

            return r;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            // 事务回滚
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            super.closeConnection();
        }
        return 0;
    }

    @Override
    public int update(Books books) {
        Connection conn = null;
        try {
            conn = super.getConnection();
            // 开启事务
            conn.setAutoCommit(false);

            // 组装sql
            String sql = "UPDATE books SET name = ?, author = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, books.getName());
            ps.setString(2, books.getAuthor());
            ps.setInt(3, books.getId());

            // 执行sql
            int r = ps.executeUpdate();

            // 提交事务
            conn.commit();

            return r;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            // 事务回滚
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            super.closeConnection();
        }

        return 0;
    }

    @Override
    public int delete(Books books) {
        Connection conn = null;
        try {
            conn = super.getConnection();
            // 开启事务
            conn.setAutoCommit(false);

            // 组装sql
            String sql = "DELETE FROM books WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, books.getId());

            // 执行sql
            int r = ps.executeUpdate();

            // 事务提交
            conn.commit();

            return r;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            // 事务回滚
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            super.closeConnection();
        }
        return 0;
    }

    @Override
    public List<Books> queryByPar(Books books, Page page) {
        List<Books> list = new ArrayList<Books>();
        try {
            // 获取数据库连接
            Connection conn = super.getConnection();
            //组装sql
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT id, name, author, create_time FROM books WHERE 1 = 1 ");

            if (books.getId() != null) {
                sql.append(" AND id = ?");
            }
            if (books.getName() != null) {
                sql.append(" AND name like ? ");
            }
            if (books.getAuthor() != null) {
                sql.append(" AND author like ? ");
            }

            // 分页
            if (page != null) {
                if (page.getSize() != null && page.getOffset() != null)
                sql.append(" LIMIT ?, ?");
            }

            // 创建查询通道
            PreparedStatement ps = conn.prepareStatement(sql.toString());

            // 给占位符设置值
            int index = 0;
            if (books.getId() != null) {
                ps.setObject(++index, books.getId());
            }
            if (books.getName() != null) {
                ps.setObject(++index, books.getName());
            }
            if (books.getAuthor() != null) {
                ps.setObject(++index, books.getAuthor());
            }

            // 分页设置值
            if (page != null) {
                if (page.getSize() != null && page.getOffset() != null){
                    ps.setObject(++index, page.getOffset());
                    ps.setObject(++index, page.getSize());
                }
            }

            // 执行查询
            ResultSet rs = ps.executeQuery();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // 遍历结果集
            while (rs.next()) {
                books = new Books();
                books.setId(rs.getInt("id"));
                books.setName(rs.getString("name"));
                books.setAuthor(rs.getString("author"));
                String create_time = sdf.format(rs.getTimestamp("create_time"));
                books.setCreateTime(create_time);
                list.add(books);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            super.closeConnection();
        }

        return list;
    }
}
