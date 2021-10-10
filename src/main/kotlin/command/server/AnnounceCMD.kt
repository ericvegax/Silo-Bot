package command.server

import BotUtil
import command.ICommand
import dev.kord.common.Color
import dev.kord.common.entity.ChannelType
import dev.kord.core.Kord
import dev.kord.core.behavior.channel.createMessage
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import dev.kord.rest.builder.message.EmbedBuilder
import dev.kord.rest.builder.message.create.embed
import kotlinx.datetime.Clock

class AnnounceCMD : ICommand {

    override fun onCommand(client: Kord) {
        client.on<MessageCreateEvent> {
            val args = message.content.split(" ")
            val c = BotUtil.getMainEmbedColor()

            if (message.getChannel().type == ChannelType.DM) return@on

            if (args[0] == "${BotUtil.getCommandPrefix()}announce") {

                message.getChannel().createMessage {
                    content = "This is a test!"

                    embed {
                        title = "Title of an Embed"

                        description = "Description of an Embed"

                        color = Color(c[0], c[1], c[2])

                        timestamp = Clock.System.now()

                        author {
                            this.name = message.getAuthorAsMember()?.displayName
                            this.url = member?.avatar?.cdnUrl?.toUrl()
                            this.icon = url
                        }

                        field {
                            name = "Name Of A Field"
                            value = "Value Of A Field ewiufh qflqihf qiwhf qlwihf"
                            inline = false
                        }

                        field {
                            name = "Another Field"
                            value = "Another Value Of A Field qhwlkhq wdlkhqwf lkqhf lkhqw flkqhwf lkqwhf "
                            inline = true
                        }

                        footer {
                            text = "Footer Text"
                            icon = ""
                        }
                    }

                    embed {

                        title = "Embed 2"

                        description = EmbedBuilder.ZERO_WIDTH_SPACE

                        color = Color(c[0], c[1], c[2])

                        thumbnail {
                            url = "https://cdn.betterttv.net/emote/55028cd2135896936880fdd7/3x"
                        }

                        field {
                            name = "Name of a field 2"
                            value = "Value of a field 2"
                            inline = true
                        }

                        footer {
                            text = "GoldenCodes made this"
                            icon = member?.avatar?.cdnUrl?.toUrl()
                        }
                    }

                    embed {
                        title = "Title"
                        color = Color(1, 2, 10)

                        url = "https://www.youtube.com/watch?v=5zwY50-necw"
                    }
                }
            }
        }
    }
}