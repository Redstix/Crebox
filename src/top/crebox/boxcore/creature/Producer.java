package top.crebox.boxcore.creature;

import top.crebox.boxcore.creature.species.SpeciesProducer;
import top.crebox.boxcore.sandbox.Nature;
import top.crebox.boxcore.sandbox.Sandbox;

import java.util.Random;

public class Producer extends Creature{
    public SpeciesProducer OwnSpeciesProducer;
    public int MoveAngle;
    @Override
    public void onCreate(Sandbox box) {
        MoveAngle=(int)(Math.random()*360);
    }
    @Override
    public void onTick(Sandbox box,int delay) {
        //移动
        if(Math.abs(pos.x) >=box.getSandboxBorderSize()-10 ||
                Math.abs(pos.y) >=box.getSandboxBorderSize()-10) {
            MoveAngle=Math.abs(180-MoveAngle);
        }
        pos.movePosByAngle(MoveAngle,this.OwnSpecies.MoveSpeed);
        //光合
        this.TotalEnergy = this.TotalEnergy + box.TheNature.getEnergy();
        //繁殖
        if(this.TotalEnergy >= 2 * this.OwnSpecies.BreedEnergy) {
            Producer son=new Producer();
            son.MoveAngle=Math.abs(MoveAngle-90);
            son.OwnSpecies=OwnSpecies;
        }
    }
}
