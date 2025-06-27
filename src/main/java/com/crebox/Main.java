package com.crebox;

import com.crebox.core.creature.CreatureBase;
import com.crebox.core.creature.CreatureEntity;
import com.crebox.core.sandbox.BoxManager;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hello world!");
        BoxManager boxManager =new BoxManager();
        boxManager.addCreature(new CreatureEntity());
        for(int i=0;i<3000;i++) {


            System.out.println("BoxTime:"+boxManager.getBoxTime()+"|-----------");
            List<CreatureBase> creatureList=boxManager.getCreatureList();
            if(!creatureList.isEmpty()){
                CreatureEntity aCreature= (CreatureEntity) creatureList.get(0);
                System.out.println("Count:"+creatureList.size());
                System.out.println(aCreature.creatureEnergy+" "+aCreature.keepAlive());
            }
            else{
                System.out.println("EMPTY");
            }
            boxManager.onTick(50);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("What f?");
            }
        }
    }
}