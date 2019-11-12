package com.locusnine.backend

import com.locusnine.user.User
import com.wizpanda.exception.ResourceNotFoundException
import com.wizpanda.utils.DomainUtils
import grails.gorm.transactions.Transactional
import grails.web.databinding.DataBindingUtils
import org.grails.web.json.JSONObject

/**
 * Service class to handle the buisness logic and the commonly used method required for user management.
 *
 * @author Ankit Kumar Singh
 */
@Transactional
class UserService {

    /**
     * Method to create a new user.
     * @param requestData
     */
    void createUser(JSONObject requestData) {
        User userInstance = new User()
        bindUserData(userInstance, requestData)
    }

    /**
     * Method to update an existing user.
     * @param requestData
     */
    void updateUser(JSONObject requestData) {
        User userInstance = User.get(requestData.id)
        if (!userInstance) {
            throw new ResourceNotFoundException("User not found!")
        }

        bindUserData(userInstance, requestData)
    }

    /**
     * Common method to bind and save user data to database.
     * @param userInstance
     * @param requestData
     */
    private void bindUserData(User userInstance, JSONObject requestData) {
        DataBindingUtils.bindObjectToInstance(userInstance, requestData, null, null, null)
        DomainUtils.save(userInstance, [failOnError: true], log)
    }
}
