import dev.kord.core.Kord
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on

suspend fun main() {
    val client = Kord("ODk2NTI2NzQ2NjIxNDU2NDE0.YWIZmQ.hvq3Aa1JjUBLNUV2fU5O6RR3-1g")

    client.on<MessageCreateEvent> {
        if (message.content == "Test")
            message.getChannel().createMessage("It works!")
    }

    client.login()
}