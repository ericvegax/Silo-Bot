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

            if (args.size == 1) {
                if (args[0] == "${prefix}help") {
                    message.getChannel().createMessage {

                        embed {
                            title = null
                            description = "Here's a list of my commands"
                            color = Color(eColor[0], eColor[1], eColor[2])
                            timestamp = Clock.System.now()

                            var builder: StringBuilder = StringBuilder()

                            for (i in 0 until BotUtil.getCommandsMap()["general"]?.size!!)
                                builder.append("${BotUtil.getCommandsMap()["general"]!![i]}\n")

                            if (message.getAuthorAsMember()?.getPermissions()
                                    ?.contains(Permission.Administrator) == false
                            ) {
                                field {
                                    name = "General Commands"
                                    inline = false
                                    value = builder.toString()
                                }
                            } else {
                                field {
                                    name = "General Commands"
                                    inline = false
                                    value = builder.toString()
                                }

                                for (i in 0 until BotUtil.getCommandsMap()["admin"]?.size!!)
                                    builder = builder.append("${BotUtil.getCommandsMap()["admin"]!![i]}\n")

                                field {
                                    name = "Admin Commands"
                                    inline = false
                                    value = builder.toString()
                                }
                            }


                            footer {
                                this.text = member?.getGuild()?.getOwner()?.displayName.toString()
                                this.icon = member?.getGuild()?.getOwner()?.avatar?.cdnUrl?.toUrl()
                            }
                        }

                    }
                }
            } else {
                message.getChannel().createMessage {
                    embed {
                        title = "Incorrect Usage!"
                        description = "Usage: `!help`"
                        color = Color(208, 0, 0)
                    }
                }
            }
        }
    }
}