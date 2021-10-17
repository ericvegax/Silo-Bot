import command.HelpCMD
import command.server.AboutCMD
import command.server.CreateEmbedCMD
import command.server.ClearCMD
import command.server.ticket.SetupTicketSystemCMD
import dev.kord.common.entity.PresenceStatus
import dev.kord.core.Kord
import listener.button.TicketButton

suspend fun main() {
    val token = System.getenv("BOT_TOKEN")
        ?: throw Exception("Must include bot token in environment variable for bot to run")

    val client = Kord(token)

    registerCommands(client)
    registerListeners(client)

    client.login {
        presence {
            afk = false
            status = PresenceStatus.Online
            listening("!help")
        }
    }
}

fun registerListeners(client: Kord) {
    TicketButton().onEvent(client)
}

fun registerCommands(client: Kord) {
    CreateEmbedCMD().onCommand(client)
    ClearCMD().onCommand(client)
    HelpCMD().onCommand(client)
    AboutCMD().onCommand(client)
    SetupTicketSystemCMD().onCommand(client)
}
