package listener

import dev.kord.core.Kord

interface IListener {

    fun onEvent(client: Kord)
}