package util

class UtilDiscord {

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
        "**!setticketmsg** Set the message shown for each new ticket",
        "**!setticketcategory** Set the category to create tickets in",
        "**!settranscriptlog** Set the log for where transcripts will go",
        "**!setticketsopen (true/false)** Change whether or not tickets can be created",
        "**!setmaxtickets (amount)** Set the max amount of tickets per user"
    )

    private val commandList = mapOf("general" to generalCommands, "admin" to adminCommands)

    companion object {
        fun getCommandsMap(): Map<String, List<String>> {
            return UtilDiscord().commandList
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
}