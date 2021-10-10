package command

import dev.kord.core.Kord
import dev.kord.core.behavior.channel.createMessage
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import dev.kord.rest.builder.message.EmbedBuilder
import dev.kord.rest.builder.message.create.embed
import kotlinx.datetime.Clock

class HelpCMD : ICommand {

    /*
        - Put all commands in a list
        - write an equation to continously get the upper & lower bound in the list
        - create a dynamic embed in order to display the commands
     */

    val commands = listOf(
        "**!help** Displays all my commands",
        "**!about** Get to know me",
        "**!status** Get info on the status of Silo",
        "**!new** Create a new ticket",
        "**!close** Close a ticket",
        "**!info** View info on a ticket",
        "**!transcript** Get a transcript of the conversation",
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
        "!setmaxtickets (amount)",
        "!",
        "!"
    ).toList()

    override fun onCommand(client: Kord) {
        client.on<MessageCreateEvent> {
            val args = BotUtil.getArgs(message.content)
            val eColor = BotUtil.getMainEmbedColor()
            val prefix = BotUtil.getCommandPrefix()

            if (args[0] == "${prefix}help") {
                message.getChannel().createMessage {
                    embed {
                        title = "Command List"
                        description = EmbedBuilder.ZERO_WIDTH_SPACE
                        timestamp = Clock.System.now()
                        footer {
                            this.text = "Indeedious#0001"
                            this.icon = member?.avatar?.cdnUrl?.toUrl()
                        }
                    }
                }
            }
        }
    }

    fun getPage(displayPage: Int) {
        var page = displayPage + 1
        var upperbound = displayPage / 2
        var lowerbound = upperbound * 2

    }
}