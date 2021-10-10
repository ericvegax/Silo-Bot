package command.server

import command.ICommand
import dev.kord.common.Color
import dev.kord.core.Kord
import dev.kord.core.behavior.channel.createMessage
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import dev.kord.rest.builder.message.create.embed
import kotlinx.coroutines.flow.toList

class ClearCMD : ICommand {

    override fun onCommand(client: Kord) {
        client.on<MessageCreateEvent> {
            val args = BotUtil.getArgs(message.content)
            val eColor = BotUtil.getMainEmbedColor()
            val prefix = BotUtil.getCommandPrefix()

            if (args[0] == "${prefix}clear") {
                if (args.size < 2) { // Send an Error for improper usage (!clear amount or !clear all)
                    message.getChannel().createMessage {
                        content = "**Incorrect Usage**"

                        embed {
                            description = "Usage: `!clear <amount> | !clear all`"
                            color = Color(255, 0, 0)
                        }
                    }
                } else {
                    try {
                        for (m in message.getChannel().messages.toList()) {
                            for (i in 0..Integer.valueOf(args[1])) {
                                m.getChannel().lastMessage?.delete()
                            }
                        }
                    } catch (e: NumberFormatException) {
                        message.getChannel().createMessage {
                            content = "**Invalid Number**"

                            embed {
                                description = "Usage: `!clear <amount> | !clear all`"
                                color = Color(255, 0, 0)
                            }
                        }
                    }
                }
            }
        }
    }
}