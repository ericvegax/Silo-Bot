package command

import dev.kord.core.Kord

interface ICommand {
    fun onCommand(client: Kord)
}