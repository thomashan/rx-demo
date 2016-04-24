package au.com.nab.message

trait Message {
    MessageType messageType
    String version
    String from
    String to
    String body

    abstract String message()
}
