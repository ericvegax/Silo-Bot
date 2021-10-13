package command.server

import command.ICommand
import dev.kord.common.Color
import dev.kord.core.Kord
import dev.kord.core.behavior.channel.createMessage
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import dev.kord.rest.builder.message.create.actionRow
import dev.kord.rest.builder.message.create.embed

class AboutCMD : ICommand {

    override fun onCommand(client: Kord) {
        client.on<MessageCreateEvent> {
            val args = BotUtil.getArgs(message.content)
            val eColor = BotUtil.getMainEmbedColor()
            val prefix = BotUtil.getCommandPrefix()

            if (args.size == 1) {
                if (args[0] == "${prefix}about") {

                    message.getChannel().createMessage {

                        embed {
                            title = null
                            description = "About Me\n"
                            color = Color(eColor[0], eColor[1], eColor[2])

                            var builder: StringBuilder = StringBuilder()

                            field {

                                builder.append("`Moderation` Oversees this server and watch for any rules broken at all times\n")
                                builder.append("`Management` Handles anything from welcomes to announcements, suggestions, resource updates, and more!\n")

                                name = "Purpose\n"
                                value = builder.toString()
                                inline = false
                            }

                            field {

                                builder = StringBuilder()

                                builder.append("`Ticket System` Able to create & manage Tickets\n")
                                builder.append("`Punishment System` Contains the ability to detect broken rules\n")
                                builder.append("`Payment System` Able to handle any transaction securely with PayPal\n")

                                name = "Features\n"
                                value = builder.toString()
                                inline = false
                            }

                            field {

                                builder = StringBuilder()

                                builder.append("`Kord` This bot was built using an idiomatic Kotlin Wrapper for the Discord API\n")
                                builder.append("`Heroku` Currently, the 24/7 hosting of this bot is handled by Heroku\n")

                                name = "Back-End"
                                value = builder.toString()
                                inline = false
                            }

                            footer {
                                text = member?.getGuild()?.getOwner()?.displayName.toString()
                                icon = member?.getGuild()?.getOwner()?.avatar?.cdnUrl?.toUrl()
                            }
                        }

                        actionRow {
                            linkButton("https://github.com/kordlib/kord") {
                                label = "Kord"
                            }

                            linkButton("https://heroku.com") {
                                label = "Heroku"
                            }
                        }
                    }
                }
            } else if (args[0] == "${prefix}about" && args.size > 1) {
                message.getChannel().createMessage {
                    embed {
                        title = "Incorrect Usage!"
                        description = "Usage: `!about`"
                        color = Color(208, 0, 0)
                    }
                }
            }
        }
    }
}