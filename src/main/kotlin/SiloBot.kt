import command.HelpCMD
import command.server.AnnounceCMD
import command.server.ClearCMD
import dev.kord.common.entity.PresenceStatus
import dev.kord.core.Kord

suspend fun main() {
    val token = System.getenv("BOT_TOKEN")
        ?: throw Exception("Must include bot token in environment variable for bot to run")

    val client = Kord("ODk2NTI2NzQ2NjIxNDU2NDE0.YWIZmQ.hvq3Aa1JjUBLNUV2fU5O6RR3-1g")

    registerCommands(client)

    client.login {
        presence {
            afk = false
            status = PresenceStatus.Online
            listening("!help")
        }
    }
}

fun registerCommands(client: Kord) {
    AnnounceCMD().onCommand(client)
    ClearCMD().onCommand(client)
    HelpCMD().onCommand(client)
}

object BotUtil {
    private val generalCommands = listOf(
        "**!help** Displays all my commands",
        "**!about** Get to know me",
        "**!status** Get info on the status of Silo",
        "**!new** Create a new ticket",
        "**!close** Close a ticket",
        "**!info** View info on a ticket",
        "**!transcript** Get a transcript of the conversation"
    ).toList()

    private val adminCommands = listOf(
        "**!add (user) (#channel)** Add a member to a ticket",
        "**!remove (user) (#channel)** Remove a member from a ticket",
        "**!rename** Rename a ticket",
        "**!closeall** Close all open tickets",
        "**!blacklist (@user)** Blacklist a user from Silo commands",
        "**!unblacklist (@user)** Remove a user from the blacklist",
        "**!blacklists** view all of the current blacklists",
        "!setticketmsg",
        "!setticketcategory",
        "!settranscriptlog",
        "!setticketsopen (true/false)",
        "!setmaxtickets (amount)"
    )

    private val commandList = mapOf("general" to generalCommands, "admin" to adminCommands)

    fun getCommandsMap(): Map<String, List<String>> {
        return commandList
    }

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
