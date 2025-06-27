package com.crebox.core.creature;

import com.crebox.core.sandbox.BoxNature;
import com.crebox.core.sandbox.BoxPos;

public class CreatureEntity extends CreatureBase{
    public BoxPos creaturePos;
    public CreatureGene creatureGene;
    public double creatureEnergy;

    private boolean isAlive = true;

    public CreatureEntity(){
        creaturePos=new BoxPos(0.0,0.0);
        creatureGene =new CreatureGene();
        creatureEnergy=13000;
    }
    public CreatureEntity(BoxPos pos,CreatureGene gene,double energy){
        creaturePos=pos;
        creatureGene=gene;
        creatureEnergy=energy;
    }
    @Override
    public void onTick(int deltaTimeMS) {
        doPhotoSyn(deltaTimeMS);
        randomMove(deltaTimeMS);
        doBreath(deltaTimeMS);
        if(checkIfClone()) {
            doClone();
        }
    }
    private void randomMove(int deltaTimeMS) {
        double angle=Math.random()*360;
        creaturePos.move(angle,
            this.calcEnvironmentBuff()*creatureGene.moveAbility /10.0/(1000.0 /deltaTimeMS));
    }
    private void doPhotoSyn(int deltaTimeMS) {
        if(creatureGene.photoSynAbility > 0.0) {
            BoxNature boxNature = boxManager.getBoxNature();
            creatureEnergy+=this.calcEnvironmentBuff()*
                    boxNature.doPhotoSyn(creatureGene.photoSynAbility)*(1000.0/deltaTimeMS);
        }
    }
    private void doBreath(int deltaTimeMS) {
        double energyCost= this.boxManager.getBoxNature().
                doBreath(
                        this.creatureGene.calculateTotalEnergyNeedPerSecond()
                                /this.calcEnvironmentBuff()
                                /(1000.0/deltaTimeMS) )
                ;
        if(energyCost>this.creatureEnergy) {
            isAlive = false;
            creatureEnergy=0;
            return;
        }
        creatureEnergy-=energyCost;
    }
    private boolean checkIfClone() {
        System.out.println("@@@NEED:"+creatureGene.calculateTotalEnergyNeedToClone());
        return creatureEnergy >= 2 * creatureGene.calculateTotalEnergyNeedToClone();
    }
    private void doClone() {
        System.out.println("@@@Cloned!");
        BoxPos childPos=this.creaturePos;
        childPos.x+=Math.random()*3-1.5;
        childPos.y+=Math.random()*3-1.5;
        CreatureEntity child=new CreatureEntity(
                childPos,this.creatureGene.getRandomChangedGene(),
                this.creatureEnergy/2.0);
        this.creatureEnergy/=2.0;
        this.boxManager.addCreature(child);
    }
    private double calcEnvironmentBuff() {
        double Te=this.boxManager.getBoxNature().getNatureTemperature(this.creaturePos);
        double Buff=1.0;
        if(Te>=10){
            Buff+=(this.creatureGene.heatProofAbility-(Te-10))/100;
            if(Buff<=0.01)
                Buff=0.01;
        }
        if(Te<=-10){
            Buff+=(this.creatureGene.coldProofAbility-(-Te-10))/100;
            if(Buff<=0.01)
                Buff=0.01;
        }
        return Buff;
    }
    @Override
    public boolean keepAlive() {
        return isAlive;
    }


}
