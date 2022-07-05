
import {RestRepository }from "./RestRepository.js";


const domain = "http://localhost:8090";
/**
 * UserService class is responsible for handling all user related operations.
 */
export  class UserService {
   
    /**
     * Fetch all users.
     * @returns 
     */
    fetchAll() {
        return RestRepository.get(`${domain}/api/user/`);
    }

    /**
     * Fetch a user by id.
     * @param {Long} userId 
     * @returns 
     */
    fetch(userId) {
        return RestRepository.get(`${domain}/api/user/${userId}`);
    }

    /**
     * 
     * @param {String} query 
     * @returns 
     */
    search(query) {
        return RestRepository.get(`${domain}/api/user/search/?q=${query}`);
    }

    /**
     * Update an existing user.
     * @param {User} user 
     * @returns 
     */
    update(user) {
        return RestRepository.put(`${domain}/api/user/${user.id}`, user);
    }

    /**
     * Create a new user.
     * @param {String} url
     * @param {User} user 
     * @returns 
     */
    create(user) {
        return RestRepository.post(`${domain}/api/user/`, user);
    }
    /**
     * Save a user.
     * @param {String} user 
     * @returns 
     */
    save(user) {
        if (user.id) {
            return this.update(user);
        } else {
            return this.create(user);
        }
    }

    /**
     * Delete a user.
     * @param {String} userId 
     * @returns 
     */
    delete(userId) {
        return RestRepository.delete(`${domain}/api/users/${userId}`);
    }
}