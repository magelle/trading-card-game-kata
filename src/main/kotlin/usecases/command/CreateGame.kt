package usecases.command

import entities.Game

class CreateGame {
    fun exec(): Game = Game()
}
