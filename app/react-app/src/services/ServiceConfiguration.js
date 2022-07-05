import {UserService} from "./UserService.js";
import { RestRepository } from "./RestRepository.js";

export const userService = new UserService();

/**
 * ServiceConfiguration class is responsible for handling all service related operations.
 */
export const ServiceConfiguration = {
    /**
     * UserService class is responsible for handling all user related operations.
     */
    userService,
    restDataProvider : RestRepository,
}