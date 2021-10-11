import command.ICommand
import command.server.AnnounceCMD
import command.server.ClearCMD
import dev.kord.common.entity.PresenceStatus
import dev.kord.core.Kord

suspend fun main() {

    val token = System.getenv("BOT_TOKEN")
        ?: throw Exception("Must include bot token in environment variable for bot to run")

    val client = Kord("ODk2NTI2NzQ2NjIxNDU2NDE0.YWIZmQ.hvq3Aa1JjUBLNUV2fU5O6RR3-1g")

    AnnounceCMD().onCommand(client)
    ClearCMD().onCommand(client)

    client.login {
        name = "Silo"
        presence {
            afk = false
            status = PresenceStatus.Online
            playing("!help")
            competing("Competing")
        }
    }
}

object Registration {
    fun registerCommand(command: ICommand) {

    }

    fun registerListener() {

    }
}

object BotUtil {
    fun getArgs(s: String): List<String> {
        return s.split(" ")
    }

    fun getMainEmbedColor(): List<Int> {
        return listOf(255, 215, 0).toList()
    }

    fun getCommandPrefix(): String {
        return "!"
    }
}
