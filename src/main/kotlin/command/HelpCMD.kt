package command

import dev.kord.common.Color
import dev.kord.common.entity.Permission
import dev.kord.core.Kord
import dev.kord.core.behavior.channel.createMessage
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import dev.kord.rest.builder.message.create.embed

class HelpCMD : ICommand {

    override fun onCommand(client: Kord) {
        client.on<MessageCreateEvent> {

            val args = BotUtil.getArgs(message.content)
            val eColor = BotUtil.getMainEmbedColor()
            val prefix = BotUtil.getCommandPrefix()
            
            if (args[0] == "${prefix}help") {
                if (message.getAuthorAsMember()?.getPermissions()?.contains(Permission.Administrator) == true) {
                    message.getChannel().createMessage {

                        embed {
                            description = "These are all my commands"
                            color = Color(eColor[0], eColor[1], eColor[2])
                            field {
                                inline = true
                                name = "General Commands"
                                for (command in BotUtil.getCommandsMap()["general"]!!) {
                                    value = command
                                }
                            }

                            footer {
                                this.text = "Indeedious#0001"
                                this.icon = member?.avatar?.cdnUrl?.toUrl()
                            }
                        }
                    }
                } else {
                    message.getChannel().createMessage {

                        embed {
                            description = "All Bot Commands"
                            color = Color(eColor[0], eColor[1], eColor[2])
                            field {
                                inline = true
                                name = "General Commands"
                                for (command in BotUtil.getCommandsMap()["general"]!!) {
                                    value = command
                                }
                            }

                            field {
                                inline = true
                                name = "Admin Commands"
                                for (command in BotUtil.getCommandsMap()["admin"]!!) {
                                    value = command
                                }
                            }

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
}