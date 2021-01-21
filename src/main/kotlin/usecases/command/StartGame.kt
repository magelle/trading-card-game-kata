package usecases.command

import entities.Game

class StartGame(private val game: Game) {
    fun exec() {
        game.start()
    }
}
