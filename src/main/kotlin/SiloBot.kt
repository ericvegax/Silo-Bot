import command.server.AnnounceCMD
import dev.kord.core.Kord

suspend fun main() {
    val client = Kord("ODk2NTI2NzQ2NjIxNDU2NDE0.YWIZmQ.hvq3Aa1JjUBLNUV2fU5O6RR3-1g")

    AnnounceCMD().onCommand(client)

    client.login()
}

open class SiloBot {

    open fun getMainEmbedColor(): List<Int> {
        return listOf(255, 215, 0).toList()
    }

    open fun getCommandPrefix(): String {
        return "!"
    }
}
