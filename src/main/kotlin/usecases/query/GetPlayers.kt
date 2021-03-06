package usecases.query

import entities.Game
import usecases.query.PlayerState.Companion.from

class GetPlayer1(private val game: Game) {
    fun get(): PlayerState = from(game.player1)
}

class GetPlayer2(private val game: Game) {
    fun get(): PlayerState = from(game.player1)
}
