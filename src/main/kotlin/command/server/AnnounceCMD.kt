package command.server

import SiloBot
import command.ICommand
import dev.kord.common.Color
import dev.kord.common.entity.ChannelType
import dev.kord.core.Kord
import dev.kord.core.behavior.channel.createEmbed
import dev.kord.core.cache.data.EmojiData
import dev.kord.core.entity.GuildEmoji
import dev.kord.core.entity.Icon
import dev.kord.core.entity.ReactionEmoji
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import dev.kord.rest.route.Route

class AnnounceCMD : ICommand {

    override fun onCommand(client: Kord) {
        client.on<MessageCreateEvent> {
            val args = message.content.split(" ")

            if (message.getChannel().type == ChannelType.DM) return@on

            var channel = message.mentionedChannels

            if (args[0] == "${SiloBot().getCommandPrefix()}announce") {

                var announcement = message.getChannel().createEmbed {
                    title = "Test"
                    description = ""
                    color = Color(SiloBot().getMainEmbedColor()[0], SiloBot().getMainEmbedColor()[1], SiloBot().getMainEmbedColor()[2])
                    footer {
                        icon = ""
                        text = "Created by GoldenCodes"
                    }
                }
            }
        }
    }
}