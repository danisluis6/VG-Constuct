package lorence.vgconstruct.custom.adapter;

/**
 * Created by vuongluis on 4/14/2018.
 *
 * @author vuongluis
 * @version 0.0.1
 */

public class CardConfig {
    private int cardMargin;
    private int cardWidth;
    private int cardHeight;
    private int priorityCardHeight;
    private int priorityCardWidth;

    public CardConfig(int cardMargin, int cardWidth, int cardHeight, int priorityCardHeight, int priorityCardWidth) {
        this.cardMargin = cardMargin;
        this.cardWidth = cardWidth;
        this.cardHeight = cardHeight;
        this.priorityCardHeight = priorityCardHeight;
        this.priorityCardWidth = priorityCardWidth;
    }

    public int getCardWidth() {
        return cardWidth;
    }

    public int getCardMargin() {
        return cardMargin;
    }

    public int getCardHeight() {
        return cardHeight;
    }

    public int getPriorityCardHeight() {
        return priorityCardHeight;
    }

    public int getPriorityCardWidth() {
        return priorityCardWidth;
    }
}
