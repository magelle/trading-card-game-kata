package entities

class Hand {
    private val cards: MutableList<Card> = mutableListOf()

    fun add(card: Card) {
        cards.add(card)
    }

    fun size() = cards.size
}