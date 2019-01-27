package com.example.dto.inputs;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UserInput")
public class UserInput {

    @ApiModelProperty(example = "user@user.com", required = true)
    @NotEmpty
    private String username;

    @ApiModelProperty(example = "P@ssw0rd", required = true)
    @NotEmpty
    private String password;

    @ApiModelProperty(example = "User", required = true)
    private String firstName;

    @ApiModelProperty(example = "LastName", required = true)
    private String lastName;

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
