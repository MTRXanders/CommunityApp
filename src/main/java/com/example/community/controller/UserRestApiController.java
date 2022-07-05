package com.example.community.controller;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.community.model.User;
import com.example.community.service.CrudService;

import com.example.community.utils.CustomTypeError;

@RestController
@RequestMapping("/api")
public class UserRestApiController {
    
    @Autowired
    private  CrudService<User>  userService;
    
    public static final Logger logger = LoggerFactory.getLogger(UserRestApiController.class);

    // -------------------Retrieve All Users----------------------------------
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.findAllEntities();

        if (users.isEmpty())
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
    
    // -------------------Retrieve Single User----------------------------------
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
        Optional<User> user = userService.findById(id);

        if (!user.isPresent())
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<User>(user.get(), HttpStatus.OK);
    }

    // -------------------Create a User-------------------------------------------
    // @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        logger.info("Creating User : {}", user);
 
        if (userService.isEntityExist(user)) {
            logger.error("Unable to create. A User with name {} already exist", user.getName());
            return new ResponseEntity<CustomTypeError>(new CustomTypeError("Unable to create. A User with name " + 
            user.getName() + " already exist."),HttpStatus.CONFLICT);
        }
        userService.saveEntity(user);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update a User ------------------------------------------------
 
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        logger.info("Updating User with id {}", id);
 
        Optional<User> currentUser = userService.findById(id);
 
        if (!currentUser.isPresent()) {
            logger.error("Unable to update. User with id {} not found.", id);
            return new ResponseEntity<CustomTypeError>(
                new CustomTypeError("Unable to upate. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND
            );
        }
        User current = currentUser.get();
        current.setRoles(user.getRoles());
        current.setName(user.getName());
        current.setClaims(user.getClaims());
        current.setTelephone(user.getTelephone());
        current.setEmail(user.getEmail());
        userService.updateEntity(current);
        return new ResponseEntity<User>(current, HttpStatus.OK);
    }
 
    // ------------------- Delete a User-----------------------------------------
 
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        logger.info("Fetching & Deleting User with id {}", id);
 
        Optional<User> user = userService.findById(id);
        if (!user.isPresent()) {
            logger.error("Unable to delete. User with id {} not found.", id);
            return new ResponseEntity<CustomTypeError>(new CustomTypeError("Unable to delete. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        userService.deleteEntityById(id);
        return new ResponseEntity<User>(HttpStatus.OK);
    }
 
    // ------------------- Delete All Users-----------------------------
 
    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteAllUsers() {
        logger.info("Deleting All Users");
        userService.deleteAllEntities();
        return new ResponseEntity<User>(HttpStatus.OK);
    }
}
