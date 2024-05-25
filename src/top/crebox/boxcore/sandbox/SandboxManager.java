package top.crebox.boxcore.sandbox;

import top.crebox.boxcore.creature.Producer;
import top.crebox.boxcore.creature.species.SpeciesProducer;

public class SandboxManager {
    public SandboxManager(int BorderSize) {
        box=new Sandbox(BorderSize);
        UCIDCounter=1;
    }
    public void addProducer(SpeciesProducer sp,SandboxPos Pos,int Energy
            ,int MoveAngle) {
        Producer tp=new Producer();
        tp.pos=Pos;
        tp.OwnSpecies=sp;
        tp.OwnSpeciesProducer=sp;
        tp.MoveAngle=MoveAngle;
        tp.TotalEnergy=Energy;
        tp.UCID=UCIDCounter;
        UCIDCounter++;
        box.

    }
    private int UCIDCounter;
    private Sandbox box;

}
