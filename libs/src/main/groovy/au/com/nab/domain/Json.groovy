package au.com.nab.domain

import groovy.json.JsonBuilder

trait Json {
    String toJson() {
        new JsonBuilder(this).toString()
    }
}
