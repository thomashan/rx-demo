package au.com.nab.account

import grails.converters.JSON

trait Json {
    String toJson() {
        this as JSON
    }
}
