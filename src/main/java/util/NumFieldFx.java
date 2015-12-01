package util;

/* Developer: Philip Churchill
** Date: 2015.11.20
** Configuration Version: 1.0.0
*/

/**
 * This is a Custom TextField that insures the user can only input
 * numerical characters and ignores other non-numerical characters.
 */

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class NumFieldFx extends TextField {
    public NumFieldFx() {
        this.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
            public void handle( KeyEvent t ) {
                char ar[] = t.getCharacter().toCharArray();
                char ch = ar[t.getCharacter().toCharArray().length - 1];
                if (!(ch >= '0' && ch <= '9')) {
                    t.consume();
                }
            }
        });
    }
}
