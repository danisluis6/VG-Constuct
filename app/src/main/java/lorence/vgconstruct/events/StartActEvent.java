package lorence.vgconstruct.events;

/**
 * Created by vuongluis on 4/14/2018.
 * @author vuongluis
 * @version 0.0.1
 */

public class StartActEvent {
    private CardClickInfo mCardInfo;
    public StartActEvent(CardClickInfo cardInfo) {
        mCardInfo = cardInfo;
    }
    public CardClickInfo getClickInfo(){
        return mCardInfo;
    }
}
