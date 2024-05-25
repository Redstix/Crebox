package top.crebox.boxcore.creature;

import top.crebox.boxcore.creature.species.Species;
import top.crebox.boxcore.sandbox.Sandbox;
import top.crebox.boxcore.sandbox.SandboxCharacter;
import top.crebox.boxcore.sandbox.SandboxPos;

public class Creature implements SandboxCharacter {
    public Species OwnSpecies;
    public int UCID;
    public int TotalEnergy;

    public SandboxPos pos;
    @Override
    public void onCreate(Sandbox box) {

    }
    @Override
    public void onTick(Sandbox box,int delay) {

    }

    @Override
    public boolean keepAlive(Sandbox box) {
        return true;
    }

    @Override
    public SandboxPos getPos(Sandbox box) {
        return pos;
    }

    @Override
    public String toJson() {
        return null;
    }
}
