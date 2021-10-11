package command

import dev.kord.common.Color
import dev.kord.common.entity.Permission
import dev.kord.core.Kord
import dev.kord.core.behavior.channel.createMessage
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import dev.kord.rest.builder.message.create.embed
import kotlinx.datetime.Clock

class HelpCMD : ICommand {

    override fun onCommand(client: Kord) {
        client.on<MessageCreateEvent> {

            val args = BotUtil.getArgs(message.content)
            val eColor = BotUtil.getMainEmbedColor()
            val prefix = BotUtil.getCommandPrefix()

            if (args[0] == "${prefix}help") {
                message.getChannel().createMessage {

                    embed {
                        title = "General Commands"
                        color = Color(eColor[0], eColor[1], eColor[2])
                        timestamp = Clock.System.now()

                        var builder: StringBuilder = StringBuilder()

                        if (message.getAuthorAsMember()?.getPermissions()
                                ?.contains(Permission.Administrator) == false
                        ) {
                            for (i in 0 until BotUtil.getCommandsMap()["general"]?.size!!)
                                builder.append("${BotUtil.getCommandsMap()["general"]!![i]}\n")
                        } else {

                            for (i in 0 until BotUtil.getCommandsMap()["admin"]?.size!!)
                                builder = builder.append("${BotUtil.getCommandsMap()["admin"]!![i]}\n")

                            field {
                                name = "Admin Commands\n"
                                inline = false
                                value = builder.toString()
                            }
                        }

                        description = builder.toString()

                        footer {
                            this.text = "Indeedious#0001"
                            this.icon = member?.avatar?.cdnUrl?.toUrl()
                        }
                    }
                }

            }
        }
    }
}