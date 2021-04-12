package com.m.dao.impl;

import com.m.dao.DeptDao;
import com.m.dao.base.BaseDao;
import com.m.entity.Dept;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.TransactionIsolationLevel;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl extends BaseDao implements DeptDao {
    
    
    @Override
    public int insert(Dept dept) {
        // 自动提交
//        SqlSession session = super.getSsf().openSession(true);
        // 更换数据源
//        Connection conn = null; // 把这个改为新的临时数据源即可
//        SqlSession session = super.getSsf().openSession(conn);
        // 可以设置事务的隔离级别
//        SqlSession session = super.getSsf().openSession(TransactionIsolationLevel.NONE);

        SqlSession session = super.getSsf().openSession(); // 默认情况下是非自动提交（就是手动提交）
        int i = 0;
        try {
            i = session.insert("insert", dept);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return i;
    }

    @Override
    public int insertList(List<Dept> depts) {
        SqlSession session = super.getSsf().openSession();
        
        int i = 0;
        try {
            i = session.insert("insertList", depts);
            
            // SqlSession可以使用若干次的例子
            // 也可这么写 只是这种方式要多次插入
//            for(Dept d : depts) {
//                i += session.insert("insert", d);
//            }
            session.commit();
        } catch (Exception e) { 
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return i;
    }

    @Override
    public int update(Dept dept) {
        SqlSession session = super.getSsf().openSession();
        
        int i = 0;
        try {
            i = session.update("update", dept);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return i;
    }

    @Override
    public int delete(int deptno) {
        SqlSession session = super.getSsf().openSession();
        
        int i = 0;
        try {
            i = session.delete("delete", deptno);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return i;
    }

    @Override
    public List<Dept> query(Dept dept) {
        // session这么写 写在这就可保证其唯一性了       
        SqlSession session = super.getSsf().openSession();
        List<Dept> list = new ArrayList<>();
        try {
            list = session.selectList("query", dept);
        } catch(Exception e) {
            e.printStackTrace();
        } finally{
            session.close();
        }
        return list;
    }

    @Override
    public Dept queryById(int deptno) {
        SqlSession session = super.getSsf().openSession();
        return session.selectOne("queryById", deptno);
    }
}
