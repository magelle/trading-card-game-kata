package usecases.query

import entities.Game
import usecases.query.PlayerState.Companion.from

class GetActivePlayer(val game: Game) {
    fun get(): PlayerState? = game.getActivePlayer()?.let(::from)
}
