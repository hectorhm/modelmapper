package com.example.appcontroller;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import com.example.dto.inputs.UserInput;
import com.example.models.User;


/**
 * Mapper to User.
 */
@Component("userIO")
public class UserIO {

    private ModelMapper modelMapper;

    final Converter<UserInput, User> userConverter = new Converter<UserInput, User>() {

        @Override
        public User convert(MappingContext<UserInput, User> context) {
            UserInput userInput = context.getSource();
            // @formatter:off
            User user = new User();
            user.setUsername(userInput.getUsername());
            user.setPassword(userInput.getPassword());
            user.setFirstName( userInput.getFirstName());
            user.setLastName(userInput.getLastName());
            // @formatter:on
            return user;
        }
    };

    public UserIO() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(userConverter);
    }

    public User mapTo(UserInput userInput) {
        return this.modelMapper.map(userInput, User.class);
    }

}
