package command.server

import command.ICommand
import dev.kord.common.Color
import dev.kord.common.entity.ButtonStyle
import dev.kord.common.entity.ChannelType
import dev.kord.common.entity.Permission
import dev.kord.core.Kord
import dev.kord.core.behavior.channel.createMessage
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import dev.kord.rest.builder.message.create.actionRow
import dev.kord.rest.builder.message.create.embed
import util.UtilDiscord

class CreateEmbedCMD : ICommand {

    override fun onCommand(client: Kord) {
        client.on<MessageCreateEvent> {
            val args = message.content.split(" ")
            val c = UtilDiscord.getMainEmbedColor()

            if (message.getChannel().type == ChannelType.DM) return@on

            if (member?.getPermissions()?.contains(Permission.Administrator) == true) {
                if (args[0] == "${UtilDiscord.getCommandPrefix()}createmessage" || args[0] == "${UtilDiscord.getCommandPrefix()}cm") {
                    message.getAuthorAsMember()?.getDmChannel()?.createMessage {
                        embed {
                            title = "Message Creator"
                            description = "Enter message details below"
                            color = Color(c[0], c[1], c[2])

                            field {
                                name = "1.) Message Target"
                                value = "Specify whether this message is to be sent to a channel or member?"
                                inline = false
                            }

                            field {
                                name = "2.) Message Content"
                                value = "Enter your message"
                                inline = false
                            }
                        }

                        actionRow {
                            interactionButton(ButtonStyle.Primary, "embed_creator_button") {
                                label = "Submit Message"
                            }
                        }
                    }
                }
            }
        }
    }
}