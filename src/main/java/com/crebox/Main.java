package com.crebox;

import com.crebox.core.creature.CreatureEntity;
import com.crebox.core.sandbox.BoxManager;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hello world!");
        BoxManager boxManager =new BoxManager();
        boxManager.addCreature(new CreatureEntity());
        for(int i=0;i<100;i++) {
            boxManager.onTick(100);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("What f?");
            }
        }
    }
}