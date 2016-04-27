package au.com.nab.message

import groovy.json.JsonBuilder

class Message {
    MessageType messageType
    String version
    String from
    String to
    Map<String, Object> body

    String message() {
        new JsonBuilder(this).toString()
    }
}
