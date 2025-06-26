package com.crebox.core.sandbox;

import com.crebox.core.creature.CreatureBase;
import com.crebox.core.creature.CreatureEntity;

import java.util.ArrayList;
import java.util.List;

public class BoxManager {
    private final List<CreatureBase> creatureList= new ArrayList<>();
    private final BoxNature boxNature=new BoxNature();
    public BoxManager() {
    }
    public BoxNature getBoxNature() {
        return boxNature;
    }
    public void addCreature(CreatureBase creature) {
        creature.boxManager=this;
        creatureList.add(creature);
    }
    public boolean onTick(int deltaTimeMS) {
        for(CreatureBase i: creatureList) {
            i.onTick(deltaTimeMS);
        }
        return true;
    }
}
