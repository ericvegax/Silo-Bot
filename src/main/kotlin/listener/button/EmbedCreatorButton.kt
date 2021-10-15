package listener.button

import dev.kord.common.annotation.KordUnsafe
import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import dev.kord.core.behavior.channel.createMessage
import dev.kord.core.event.interaction.ButtonInteractionCreateEvent
import dev.kord.core.on
import dev.kord.rest.builder.message.create.embed
import listener.IListener

class EmbedCreatorButton : IListener {

    @OptIn(KordUnsafe::class, dev.kord.common.annotation.KordExperimental::class)
    override fun onEvent(client: Kord) {
        client.on<ButtonInteractionCreateEvent> {
            if (interaction.componentId == "embed_creator_button") {
                if (interaction.user.getDmChannel().getLastMessage()?.mentionedChannelIds != null
                    && interaction.user.getDmChannel().getLastMessage()?.asMessage()?.data?.content?.length!! > 16
                ) {
                    kord.unsafe.guildMessageChannel(Snowflake(767305626828275712), Snowflake("")).createMessage {
                        embed {

                        }
                    }
                }
            }
        }
    }
}