package com.m.mvc.web;

public class ModelAndView {
    private ModelMapping model;
    private View view;
    private boolean isRest;
    private Object restObj;

    public ModelMapping getModel() {
        return model;
    }

    public void setModel(ModelMapping model) {
        this.model = model;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public boolean isRest() {
        return isRest;
    }

    public void setRest(boolean rest) {
        isRest = rest;
    }

    public Object getRestObj() {
        return restObj;
    }

    public void setRestObj(Object restObj) {
        this.restObj = restObj;
    }
}
