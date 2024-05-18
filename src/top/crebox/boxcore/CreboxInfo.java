package top.crebox.boxcore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CreboxInfo {
    public static void printAbout(Boolean fullinfo){
        System.out.println("-------------------------------------------");
        File aboutfile=new File("./src/resources/boxcore/about.txt");
        if(aboutfile.exists()){
            try{
                FileReader fr=new FileReader(aboutfile);
                BufferedReader br=new BufferedReader(fr);
                String str;
                while((str=br.readLine())!=null){
                    System.out.println(str);
                }
            }catch(IOException e) {
                System.out.println(e.toString());
            }
        }

        System.out.println(crebox_version+" "+build_version);
        if(fullinfo){
            System.out.println(author_info);
        }
        System.out.println("-------------------------------------------");
    }

    public static String crebox_version="0.0.1";
    public static String build_version="build 1";

    public static String author_info="by asxzs,go github.com/asxzt/ for more info";
}
