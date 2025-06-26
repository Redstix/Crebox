package com.crebox.core.creature;

import com.crebox.core.sandbox.BoxNature;
import com.crebox.core.sandbox.BoxPos;

public class CreatureEntity extends CreatureBase{
    public BoxPos creaturePos;
    public CreatureAbility creatureAbility;
    public double creatureEnergy;

    public CreatureEntity(){
        creaturePos=new BoxPos(0.0,0.0);
        creatureAbility=new CreatureAbility();
        creatureEnergy=0;
    }
    @Override
    public void onTick(int deltaTimeMS) {
        randomMove(deltaTimeMS);
        doPhotoSyn();
        System.out.println(creaturePos.x+","+creaturePos.y);
    }
    private void randomMove(int deltaTimeMS) {
        double angle=Math.random()*360;
        creaturePos.move(angle,creatureAbility.mobilityAbility/10.0/((double) 1000.0 /deltaTimeMS));
    }
    private void doPhotoSyn() {
        BoxNature boxNature = boxManager.getBoxNature();
        creatureEnergy+=boxNature.doPhotoSyn(creatureAbility.photoSynAbility);
    }
    @Override
    public boolean keepAlive() {
        return true;
    }


}
