package top.crebox.boxcore.creature.species;
class SpeciesOutwardColor {
    int r,g,b;
}
public class SpeciesOutward {
    SpeciesOutwardColor outwardcolor;
    void setColor(int r,int g,int b){
        outwardcolor.r=r;
        outwardcolor.g=g;
        outwardcolor.b=b;
    }
    String ToJson() {
        String json="{color:["+outwardcolor.r+","+outwardcolor.g+","+outwardcolor.b+"]}";
        return  json;
    }
}
