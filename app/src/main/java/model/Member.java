package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Member implements Serializable {
    final static long serialVersionUID = 12L;
    private Integer id;
    private String name;
    private String username;
    private String password;
    private Integer music;
    private Integer soueff;
    private Integer skin;
    private ArrayList<History> histories;

    public Member() {
        this.id = 0;
        this.name = "";
        this.username = "";
        this.password = "";
        this.music = 100;
        this.soueff = 100;
        this.skin = 1;
        histories = new ArrayList<History>();
    }
    public Member(Integer id, String name, String username, String password, Integer music, Integer soueff, Integer skin, ArrayList<History> histories) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.music = music;
        this.soueff = soueff;
        this.skin = skin;
        this.histories = histories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMusic() {
        return music;
    }

    public void setMusic(Integer music) {
        this.music = music;
    }

    public Integer getSoueff() {
        return soueff;
    }

    public void setSoueff(Integer soueff) {
        this.soueff = soueff;
    }

    public Integer getSkin() {
        return skin;
    }

    public void setSkin(Integer skin) {
        this.skin = skin;
    }

    public ArrayList<History> getHistories() {
        return histories;
    }

    public void setHistories(ArrayList<History> histories) {
        this.histories = histories;
    }
}
