import java.util.HashMap;
import java.util.Iterator;

public class School {
    private HashMap<String, Pupil> pupils;

    public School(HashMap<String, Pupil> pupils) {
        if(pupils==null){
            throw new NullPointerException("pupils is null");
        }
        this.pupils = pupils;
    }

    public Pupil delPupils(String key) {
        return pupils.remove(key);
    }

    public Pupil getPupil(String key) {
        return pupils.get(key);
    }

    public void display(){
        for (String s : pupils.keySet()) {
            System.out.println(s);
        }
    }
}
