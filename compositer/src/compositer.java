import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class compositer {

    public static void main(String[] args){

diskpart folder_M = new folder("Music",0);
List<diskpart> Music = new ArrayList<>();
diskpart folder_I = new folder("Images",0);
List<diskpart> Images = new ArrayList<>();
diskpart folder_T = new folder("Text",0);
List<diskpart> Text = new ArrayList<>();
diskpart folder_B = new folder("Books",0);
List<diskpart> Books = new ArrayList<>();
diskpart file_S1 = new file("Sound1.mp3",5);
diskpart file_S2 = new file("Sound2.mp3",7);
diskpart file_S3 = new file("Sound3.mp3",3);
diskpart file_I1 = new file("image1.png",12);
diskpart file_I2 = new file("image2.png",5);
diskpart file_I3 = new file("image3.png",8);
diskpart file_T1 = new file("Text1.txt",32);
diskpart file_T2 = new file("Text2.txt",13);
diskpart file_T3 = new file("Text3.txt",76);
diskpart file_B1 = new file("Book1.pdf",63);
diskpart file_B2 = new file("Book2.epub",11);
folder root = new folder("RootFolder",0);

root.addobj(folder_M);
((folder) folder_M).addobj(file_S1);
((folder) folder_M).addobj(file_S2);
((folder) folder_M).addobj(file_S3);
root.addobj(folder_I);
((folder) folder_I).addobj(file_I1);
((folder) folder_I).addobj(file_I2);
((folder) folder_I).addobj(file_I3);
root.addobj(folder_T);
((folder) folder_T).addobj(file_T1);
((folder) folder_T).addobj(file_T2);
((folder) folder_T).addobj(file_T3);
root.addobj(folder_B);
((folder) folder_B).addobj(file_B1);
((folder) folder_B).addobj(file_B2);


root.outobj();

int getsize = root.getsize();
System.out.println("Общий размер папки = " + getsize);
    }
}

interface diskpart{

    int getsize();

    void outobj();
}
class folder implements diskpart {
    String name;
    int size;
    List<diskpart> allfiles = new ArrayList<>();

    public void addobj(diskpart obj)
    {
        allfiles.add(obj);
    }


    public void outobj(){

        System.out.println("|_" + this.name);

        for (diskpart obj:allfiles){

           obj.outobj();


        }

    }
    public int getsize() {
        int sum = 0;
        for (diskpart obj : allfiles) {
            sum = sum + obj.getsize();

        }
        return sum;
    }
folder(String n, int s){

    name = n;
    size = s;

}

}

class file implements diskpart{

    String name;
    int size;

   public int getsize(){

       return this.size;
   }
   public void outobj(){
       System.out.println("|__" + this.name);
   }

    file(String n, int s){
            name =  n;
            size = s;
    }
}