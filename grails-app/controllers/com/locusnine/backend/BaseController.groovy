package com.locusnine.backend

import com.locusnine.user.User
import com.wizpanda.core.KernelExceptionHandler
import grails.artefact.Controller
import grails.converters.JSON
import org.grails.web.converters.exceptions.ConverterException
import org.grails.web.json.JSONObject
import org.springframework.http.HttpStatus

/**
 * Abstract class to handle commonly used methods and handling exception for the controller classes.
 *
 * @author Ankit Kumar Singh
 */
abstract class BaseController extends KernelExceptionHandler implements Controller {

    static namespace = "v1"

    protected JSONObject requestData() {
        (JSONObject) request.JSON
    }

    protected JSONObject parseFilters() {
        if (!params.filters) {
            return new JSONObject()
        }

        try {
            return JSON.parse(params.filters.toString()) as JSONObject
        } catch (ConverterException e) {
            throw e
        }
    }

    def respondOk() {
        render(status: HttpStatus.OK)
    }

    def respondAccepted() {
        render(status: HttpStatus.ACCEPTED)
    }
}
