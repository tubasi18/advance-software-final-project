package edu.najah.cap.data.exportdatafeature.strategy;

import edu.najah.cap.data.exportdatafeature.strategy.interfaces.IActionable;
import edu.najah.cap.exceptions.FileFiledException;


public class ActionContext {

    private IActionable actionable;

    public void setActionable(IActionable actionable) {
        this.actionable = actionable;
    }
    public void  actionProcess(byte[] data) throws FileFiledException {
        actionable.actionProcess(data);
    }
}
