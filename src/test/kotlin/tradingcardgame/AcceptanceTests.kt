package tradingcardgame

import org.assertj.core.api.Assertions.assertThat
import usecases.command.CreateGame
import usecases.command.StartGame
import usecases.command.TurnGame
import usecases.query.GetPlayer1
import usecases.query.GetPlayer2
import kotlin.test.Test

class AcceptanceTests {

    @Test
    fun `Each player starts the game with 30 Health`() {
        val game = CreateGame().exec()

        val player1 = GetPlayer1(game).get()
        val player2 = GetPlayer2(game).get()
        assertThat(player1.health).isEqualTo(30)
        assertThat(player2.health).isEqualTo(30)
    }

    @Test
    fun `Each player starts the game with 0 Mana slots`() {
        val game = CreateGame().exec()

        val players1 = GetPlayer1(game).get()
        val players2 = GetPlayer2(game).get()
        assertThat(players1.mana).isEqualTo(0)
        assertThat(players1.manaSlot).isEqualTo(0)
        assertThat(players2.mana).isEqualTo(0)
        assertThat(players2.manaSlot).isEqualTo(0)
    }

    @Test
    fun `Each player starts with a deck of 20 Damage cards`() {
        val game = CreateGame().exec()

        val player1 = GetPlayer1(game).get()
        val player2 = GetPlayer2(game).get()
        assertThat(player1.deckSize).isEqualTo(20)
        assertThat(player2.deckSize).isEqualTo(20)
    }

    @Test
    fun `Each player starts with a deck of Damage cards with the following Mana costs 0,0,1,1,2,2,2,3,3,3,3,4,4,4,5,5,6,6,7,8`() {
        val game = CreateGame().exec()

        val player1 = GetPlayer1(game).get()
        val player2 = GetPlayer2(game).get()
        assertThat(player1.deck).containsExactlyInAnyOrder(0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 7, 8)
        assertThat(player2.deck).containsExactlyInAnyOrder(0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 7, 8)
    }

    @Test
    fun `From the deck each player receives 3 random cards has his initial hand`() {
        val game = CreateGame().exec()
        StartGame(game).exec()
        val player1 = GetPlayer1(game).get()
        val player2 = GetPlayer2(game).get()

        assertThat(player1.deckSize).isEqualTo(17)
        assertThat(player2.deckSize).isEqualTo(17)

        assertThat(player1.handSize).isEqualTo(3)
        assertThat(player2.handSize).isEqualTo(3)
    }

    @Test
    internal fun `The active player receives 1 Mana slot up to a maximum of 10 total slots`() {
        val game = CreateGame().exec()
        StartGame(game).exec()
        TurnGame(game).exec()

        val player1 = GetPlayer1(game).get()

        assertThat(player1.manaSlot).isEqualTo(1)
    }

    @Test
    fun `The active player’s empty Mana slots are refilled`() {
        val game = CreateGame().exec()
        StartGame(game).exec()
        TurnGame(game).exec()

        val player1 = GetPlayer1(game).get()

        assertThat(player1.mana).isEqualTo(1)
    }

    @Test
    fun `The active player draws a random card from his deck`() {
        val game = CreateGame().exec()
        StartGame(game).exec()
        TurnGame(game).exec()

        val player1 = GetPlayer1(game).get()

        assertThat(player1.deckSize).isEqualTo(16)
        assertThat(player1.handSize).isEqualTo(4)
    }


}

