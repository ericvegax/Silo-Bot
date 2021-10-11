package command

import dev.kord.core.Kord
import dev.kord.core.behavior.channel.createMessage
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import dev.kord.rest.builder.message.EmbedBuilder
import dev.kord.rest.builder.message.create.embed
import kotlinx.datetime.Clock
import kotlin.math.ceil

class HelpCMD : ICommand {

    /*
        - Put all commands in a list
        - write an equation to continously get the upper & lower bound in the list
        - create a dynamic embed in order to display the commands
     */

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

    fun sendCommands(page: Int) {

    }

    fun getTotalPages(): Int {
        return ceil((BotUtil.getCommandList().size / 7).toDouble()).toInt()
    }
}