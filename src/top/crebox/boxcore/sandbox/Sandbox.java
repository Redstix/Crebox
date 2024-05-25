package top.crebox.boxcore.sandbox;

import java.util.LinkedList;

public class Sandbox {
    Sandbox(int BorderSize) {
        SandBoxBorderSize=BorderSize;
    }
    public int getSandboxBorderSize() {
        return SandBoxBorderSize;
    }
    private int SandBoxBorderSize=1000;
    public Nature TheNature;

    LinkedList<SandboxCharacter> Characters;
}
