package com.crebox.core.creature;

import com.crebox.core.sandbox.BoxManager;

public abstract class CreatureBase {
    public BoxManager boxManager;
    public void onTick(int deltaTimeMS) {
    }
    public boolean keepAlive() {
        return false;
    }
}
