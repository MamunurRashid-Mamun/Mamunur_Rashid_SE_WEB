package com.icc.app.dto;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class TeamMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long teamMemberId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "countryId", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
    private Country country;

    private String name;
    private String dateOfBirth;
    private int age;
    private String role;

    public TeamMember() {
    }

    public TeamMember(Country country, String name, String dateOfBirth, int age, String role) {
        this.country = country;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.role = role;
    }

    public long getTeamMemberId() {
        return teamMemberId;
    }

    public void setTeamMemberId(long teamMemberId) {
        this.teamMemberId = teamMemberId;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "TeamMember{" +
                "teamMemberId=" + teamMemberId +
                ", country=" + country +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", age=" + age +
                ", role='" + role + '\'' +
                '}';
    }
}
