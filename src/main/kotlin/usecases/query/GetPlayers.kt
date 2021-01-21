package usecases.query

import entities.Game
import entities.Player

class GetPlayer1(val game: Game) {
    fun get(): Player = game.player1
}

class GetPlayer2(val game: Game) {
    fun get(): Player = game.player2
}