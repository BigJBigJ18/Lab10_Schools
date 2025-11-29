import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        School school=new School(new HashMap<String, Pupil>());
        Pupil p1=generatePupil("HansHuber 2EHIF Faecher Mathematik:1 Deutsch:2 POS:4 Englisch:2 " +
                "Biologie:4 Geographie:0 BSP:1");
        Pupil p2=generatePupil("Anna Schmied 2AHIF Faecher Mathematik:-1 Deutsch:1 POS:1 Englisch:2 " +
                "Biologie:4 Geographie:3 BSP:1");
        Pupil p3=generatePupil("Hans Huber 2EHIF Faecher Mathematik:1 Deutsch:2 POS:4 Englisch:2 " +
                "Biologie:4 Geographie:0 BSP:1");
        Pupil p4=generatePupil("Anna Schmied 2AHIF Faecher Mathematik:1 Deutsch:1 POS:1 Englisch:2 " +
                "Biologie:4 Geographie:3 BSP:1");
        Pupil p5=generatePupil("Jornandes Raible 2BHIF Faecher Mathematik:1 Deutsch:2 POS:1 Englisch:1 Biologie:1 BSP:1");
        System.out.println(p3.getKey());
    }

    public static Pupil generatePupil(String s){
        try{
            String[] values=s.split(" ");
            List<Subject> subjects=new ArrayList<>();
            LocalDate geb=LocalDate.now().plusDays(new Random().nextInt(1, 365*5));
            for(int i=4;i<values.length;i++){
                subjects.add(new Subject(Integer.parseInt(values[i].split(":")[1]), values[i].split(":")[0]));
            }

            return new Pupil(values[0]+" "+values[1], geb, values[2], subjects);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}