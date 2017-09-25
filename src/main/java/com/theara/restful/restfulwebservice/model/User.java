package com.theara.restful.restfulwebservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "All details about the user")
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 3, message = "Name should be more than 3 characters")
    @ApiModelProperty(notes = "Name should be more than 3 characters")
    private String name;

    @Past
    @ApiModelProperty(notes = "Birthday should be in the past")
    private Date birthDate;

    public User(){

    }

    public User(String name, Date birthDate){
        this.name = name;
        this.birthDate = birthDate;
    }

    public User(Integer id, String name, Date birthDate) {
        this(name, birthDate);
        this.id = id;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
