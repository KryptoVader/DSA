from collections import Counter

def isNStraightHand(hand, groupSize):
    if len(hand) % groupSize != 0:
            return False

    hand.sort()
    counts = Counter(hand)

    for card in hand:
        if counts[card] == 0:
            continue

        for value in range(card, card + groupSize):
            if counts[value] == 0:
                return False
            counts[value] -= 1
    return True