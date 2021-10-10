import command.server.AnnounceCMD
import command.server.ClearCMD
import dev.kord.core.Kord
import kotlinx.coroutines.processNextEventInCurrentThread

suspend fun main() {

    val client = Kord("ODk2NTI2NzQ2NjIxNDU2NDE0.YWIZmQ.hvq3Aa1JjUBLNUV2fU5O6RR3-1g")

    AnnounceCMD().onCommand(client)
    ClearCMD().onCommand(client)

    client.login()
}

object BotUtil {

    fun getArgs(s: String): List<String> {
        return s.split(" ")
    }

    fun getMainEmbedColor(): List<Int> {
        return listOf(17, 140, 79).toList()
    }

    fun getCommandPrefix(): String {
        return "!"
    }
}
