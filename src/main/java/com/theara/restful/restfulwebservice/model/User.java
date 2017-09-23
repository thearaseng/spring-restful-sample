package com.theara.restful.restfulwebservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "All details about the user")
public class User {

    private Integer id;

    @Size(min = 3, message = "Name should be more than 3 characters")
    @ApiModelProperty(notes = "Name should be more than 3 characters")
    private String name;

    @Past
    @ApiModelProperty(notes = "Birthday should be in the past")
    private Date birthDate;

    public User(){

    }

    public User(Integer id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
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
}
