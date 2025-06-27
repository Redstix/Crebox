package com.crebox.core.sandbox;

import com.crebox.core.creature.CreatureBase;
import com.crebox.core.creature.CreatureEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoxManager {
    private final List<CreatureBase> creatureList= new ArrayList<>();
    private final BoxNature boxNature;

    private int boxTime=0;
    //boxTime:(ms)
    //1 day:24s(12s day 12s night)
    public BoxManager() {
        boxNature = new BoxNature(this);
    }
    public BoxNature getBoxNature() {
        return boxNature;
    }
    public int getBoxTime() {
        return boxTime;
    }
    public void addCreature(CreatureBase creature) {
        creature.boxManager=this;
        creatureList.add(creature);
    }
    public void onTick(int deltaTimeMS) {
        boxTime += deltaTimeMS;

        List<CreatureBase> copy = new ArrayList<>(creatureList);

        for (CreatureBase creatureBase : copy) {
            if (creatureBase.keepAlive()) {
                creatureBase.onTick(deltaTimeMS);
            } else {
                creatureList.remove(creatureBase); // 安全操作
            }
        }
    }
    public List<CreatureBase> getCreatureList(){
        return creatureList;
    }
}
