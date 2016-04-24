package au.com.nab.deposit

import au.com.nab.message.Message

class DepositMessage implements Message {
    String accountName
    BigDecimal amount

    @Override
    String message() {
        return "messageType:$messageType,verion:$version,from:$from,to:$to,$body:body,accountName:$accountName,amount:$amount"
    }
}
