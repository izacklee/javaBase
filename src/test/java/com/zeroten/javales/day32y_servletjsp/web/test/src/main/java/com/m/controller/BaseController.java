package com.m.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class BaseController {
    private ServletContext application;
    private HttpServletRequest hreq;
    private HttpServletResponse hres;
    private HttpSession session;

    public ServletContext getApplication() {
        return application;
    }

    public void setApplication(ServletContext application) {
        this.application = application;
    }

    public HttpServletRequest getHreq() {
        return hreq;
    }

    public void setHreq(HttpServletRequest hreq) {
        this.hreq = hreq;
    }

    public HttpServletResponse getHres() {
        return hres;
    }

    public void setHres(HttpServletResponse hres) {
        this.hres = hres;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }
}
