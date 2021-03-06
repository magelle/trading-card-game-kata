package usecases.query

import entities.Card
import entities.Health
import entities.Mana
import entities.Player

data class PlayerState(
    val mana: Mana,
    val manaSlot: Int,
    val health: Health,
    val deckSize: Int,
    val handSize: Int,
    val deck: List<Card>,
    val hand: List<Card>
) {

    companion object {
        fun from(player: Player) = PlayerState(
            mana = player.mana,
            manaSlot = player.manaSlot,
            health = player.health,
            deckSize = player.deck.size(),
            handSize = player.hand.size(),
            deck = player.deck.allCards(),
            hand = player.hand.allCards()
        )
    }
}
