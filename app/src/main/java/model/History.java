package model;

import android.os.Build;

import java.io.Serializable;
import java.time.LocalDateTime;

public class History implements Serializable {
    final static long serialVersionUID = 11L;
    private Integer id;
    private LocalDateTime datetime;
    private Integer score;
    private Member member;
    private Level level;

    public History() {
        this.id = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.datetime = LocalDateTime.of(2023, 01, 01, 0, 0, 0);
        }
        this.score = 0;
        this.member = new Member();
    }
    public History(Integer id, LocalDateTime datetime, Integer score, Member member) {
        this.id = id;
        this.datetime = datetime;
        this.score = score;
        this.member = member;
    }

    public History(LocalDateTime datetime, Integer score, Member member, Level level) {
        this.id = 0;
        this.datetime = datetime;
        this.score = score;
        this.member = member;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
