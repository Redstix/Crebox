package top.crebox.boxcore.creature;


import java.time.LocalDateTime;

public class Species {
    String Name;
    int USID;
    SpeciesOutward Outward;
    int FoodchainLevel;
    int PsynLevel,HuntLevel,NatureEatLevel;
    int MoveSpeed;
    HuntedType OnHunted;
    int HuntMin,HuntMax;
    int MutationLevel;
    LocalDateTime CreatTime;

}
