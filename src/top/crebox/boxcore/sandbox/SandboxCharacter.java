package top.crebox.boxcore.sandbox;

public interface SandboxCharacter {
    void onCreate(Sandbox box);
    void onTick(Sandbox box,int delay);
    boolean keepAlive(Sandbox box);
    SandboxPos getPos(Sandbox box);
    String toJson();
}
