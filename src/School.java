import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class School {
    private HashMap<String, Pupil> pupils;

    public School(HashMap<String, Pupil> pupils) {
        if(pupils==null){
            throw new NullPointerException("pupils is null");
        }
        this.pupils = pupils;
    }

    public String addPupil(String name, String schoolClass, LocalDate dateOfBirth, List<Subject> subjects){
        try{
            Pupil pupil=new Pupil(name, dateOfBirth, schoolClass, subjects);
            pupils.put(pupil.getKey(),pupil);
            return pupil.getKey();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String addPupil(Pupil p){
        if(p!=null){
            pupils.put(p.getKey(),p);
            return p.getKey();
        }
        return null;
    }

    public Pupil delPupils(String key) {
        return pupils.remove(key);
    }

    public Pupil getPupil(String key) {
        return pupils.get(key);
    }

    public void display(){
        for (String s : pupils.keySet()) {
            System.out.println(pupils.get(s));
        }
    }
}
