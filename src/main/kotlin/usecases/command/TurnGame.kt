package usecases.command

import entities.Game

class TurnGame(val game: Game) {
    fun exec() {
        game.turn()
    }
}