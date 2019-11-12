package com.locusnine.backend.user

import com.locusnine.backend.BaseController
import com.locusnine.backend.UserService
import com.locusnine.user.User
import com.wizpanda.exception.ResourceNotFoundException
import org.grails.web.json.JSONObject

/**
 * Controller class to handling API endpoints for User management activities.
 *
 * @author Ankit Kumar Singh
 */
class UserController extends BaseController {

    static allowedMethods = [index: "GET", save: "POST", update: "PUT", show: "GET"]

    UserService userService

    /**
     * Endpoint to list down the user based on certain parameters.
     * @param max
     * @param offset
     * @return
     */
    def index(Integer max, Integer offset) {
        params.max = Math.min(max ?: 20, 100)
        params.sort = params.sort ?: "name"
        params.offset = offset ?: 0
        params.order = params.order ?: "desc"

        JSONObject filters = parseFilters()

        List<User> userList = User.createCriteria().list(params) {
            if (filters.query) {
                or {
                    ilike("name", "%${filters.query}%")
                    ilike("emailID", "%${filters.query}%")
                }
            }

        }

        respond(userList)
    }

    /**
     * Endpoint to save a new user.
     * @return
     */
    def save() {
        JSONObject requestData = requestData()
        userService.createUser(requestData)

        respondOk()
    }

    /**
     * Endpoint to update an existing user.
     * @return
     */
    def update() {
        JSONObject requestData = requestData()
        userService.updateUser(requestData)

        respondAccepted()
    }

    /**
     * Endpoint to display the data of an existing user.
     * @param id
     * @return
     */
    def show(Long id) {
        User userInstance = User.get(id)
        if (!userInstance) {
            throw new ResourceNotFoundException("User not found")
        }

        respond(userInstance)
    }
}
