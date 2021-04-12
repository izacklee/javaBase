package com.m.test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Service {

    private Dao dao;
    
    private String[] strs;
    private List<String> strList;
    private Set<String> strSet;
    
    public void test() {
        System.out.println("Service test ...");
        this.dao.test();
        System.out.println(this.toString());
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    public String[] getStrs() {
        return strs;
    }

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    public List<String> getStrList() {
        return strList;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public Set<String> getStrSet() {
        return strSet;
    }

    public void setStrSet(Set<String> strSet) {
        this.strSet = strSet;
    }

    @Override
    public String toString() {
        return "Service{" +
                "dao=" + dao +
                ", strs=" + Arrays.toString(strs) +
                ", strList=" + Arrays.toString(strList.toArray()) +
                ", strSet=" + Arrays.toString(strSet.toArray()) +
                '}';
    }
}
