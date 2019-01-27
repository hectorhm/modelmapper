package com.example.dto.outputs;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

public class UserOutput  {

    @ApiModelProperty(example = "1", required = true)
    @NotEmpty
    private Long id;

    @ApiModelProperty(example = "user@user.com", required = true)
    @NotEmpty
    @Email
    private String username;

    @ApiModelProperty(example = "Maria", required = true)
    private String firstName;

    @ApiModelProperty(example = "Silva", required = true)
    private String lastName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
