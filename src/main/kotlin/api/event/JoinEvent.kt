package api.event

import dev.kord.core.Kord
import dev.kord.core.behavior.UserBehavior
import dev.kord.core.event.Event
import dev.kord.core.event.message.MessageCreateEvent
import kotlin.coroutines.CoroutineContext

class JoinEvent(override val kord: Kord, override val shard: Int, override val coroutineContext: CoroutineContext)
    : Event {

    fun setJoinMessage() {

    }
}