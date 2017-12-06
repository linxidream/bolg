package com.example.mybolg.entity;

import java.util.List;

public class Role {
    private String id;
    private String role_name;
    private List<String> role_module;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public List<String> getRole_module() {
        return role_module;
    }

    public void setRole_module(List<String> role_module) {
        this.role_module = role_module;
    }
}
