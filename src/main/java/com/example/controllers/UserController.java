package com.example.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.appcontroller.AppControllerBase;
import com.example.appcontroller.UserIO;
import com.example.dto.inputs.UserInput;
import com.example.dto.outputs.UserOutput;
import com.example.models.User;
import com.example.services.UserService;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
@Api(tags = "Users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    AppControllerBase appControllerBase;

    @Autowired
    UserIO userIO;

    @PostMapping({ "/", "" })
    @ApiOperation(value = "Create an User", notes = "Also returns a link to retrieve the saved user in the location header")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserInput user) {
        User userModel = userIO.mapTo(user);
        User savedUser = userService.create(userModel);
        // @formatter:off
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
        // @formatter:on
    }

    @ApiOperation(value = "Get All Users")
    @GetMapping({ "/", "" })
    // @formatter:off
    public ResponseEntity<?> indexUsers() {
        Type type = new TypeToken<List<UserOutput>>() {}.getType();

            List<UserOutput> result = appControllerBase.toList(userService.index(), type);
            return ResponseEntity.ok(result);

    }
    // @formatter:on

    @ApiOperation(value = "Get an only User")
    @GetMapping({ "/{id}/", "/{id}" })
    public UserOutput showUser(@PathVariable("id") Long id) {
        return appControllerBase.mapTo(userService.show(id), UserOutput.class);
    }

    @PutMapping({ "/{id}/", "/{id}" })
    @ApiOperation(value = "Updates an User")
    public ResponseEntity<?> updateUser(
            // @formatter:off
            @Min(value = 1) @PathVariable("id") Long id,
            @RequestBody UserInput user) throws Exception {
        User user1= userIO.mapTo(user);
        userService.update(id, user1);
        return ResponseEntity.noContent().build();
    }
    // @formatter:on

    @DeleteMapping({ "/{id}/", "/{id}" })
    @ApiOperation(value = "Delete an User")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }


}
