package au.com.nab.deposit

import au.com.nab.message.Message
import groovy.json.JsonBuilder

class DepositMessage implements Message {
    String accountName
    BigDecimal amount

    @Override
    String message() {
        return new JsonBuilder(this).toString()
    }
}
