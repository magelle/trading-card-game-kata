package usecases.query

import entities.Card
import entities.Health
import entities.Mana
import entities.Player

class PlayerState(
    val mana: Mana,
    val health: Health,
    val deckSize: Int,
    val handSize: Int,
    val cardsInDeck: List<Card>
) {
    companion object {
        fun from(player: Player) = PlayerState(
            mana = player.mana,
            health = player.health,
            deckSize = player.deck.size(),
            handSize = player.hand.size(),
            cardsInDeck = player.deck.allCards()
        )
    }
}
