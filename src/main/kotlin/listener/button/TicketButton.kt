package listener.button

import dev.kord.core.Kord
import dev.kord.core.event.interaction.ButtonInteractionCreateEvent
import dev.kord.core.on
import listener.IListener

class TicketButton : IListener {

    override fun onEvent(client: Kord) {
        client.on<ButtonInteractionCreateEvent> {
            if (interaction.componentId == "") {

            }
        }
    }
}