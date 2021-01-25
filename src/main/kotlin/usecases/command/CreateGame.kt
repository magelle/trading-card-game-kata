package usecases.command

import entities.Game
import entities.RandomInt

class CreateGame(private val randomInt: RandomInt) {
    fun exec(): Game = Game(randomInt)
}
