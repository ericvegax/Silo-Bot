package listener

import dev.kord.common.Color
import dev.kord.core.Kord
import dev.kord.core.behavior.channel.createMessage
import dev.kord.core.event.interaction.ButtonInteractionCreateEvent
import dev.kord.core.on
import dev.kord.rest.builder.message.create.embed

class ButtonListener : IListener {

    override fun onEvent(client: Kord) {
        client.on<ButtonInteractionCreateEvent> {
            if (interaction.componentId == "kord_link") {
                interaction.user.getDmChannel().createMessage {
                    embed {
                        title = "Success"
                        description = "Detected the button being pressed!"
                        color = Color(0, 100, 0)
                    }
                }
            }
        }
    }
}