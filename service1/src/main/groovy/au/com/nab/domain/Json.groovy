package au.com.nab.domain

import grails.converters.JSON

trait Json {
    String toJson() {
        return this as JSON
    }
}
