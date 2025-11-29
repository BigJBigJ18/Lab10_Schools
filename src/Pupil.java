import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Pupil {
    private String name;
    private LocalDate dateOfBirth;
    private String schoolClass;
    private List<Subject> subjects;

    public Pupil(String name, LocalDate dateOfBirth, String schoolClass, List subjects) {
        setName(name);
        setDateOfBirth(dateOfBirth);
        setSchoolClass(schoolClass);
        setSubjects(subjects);
    }

    public void setName(String name) {
        if(name==null || name.isEmpty()){
            throw new IllegalArgumentException("Name darf nicht null oder leer sein");
        }
        this.name = name;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if(dateOfBirth==null || dateOfBirth.isAfter(LocalDate.now().plusYears(10))){
            throw new IllegalArgumentException("Datum nicht null oder leer sein");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public void setSchoolClass(String schoolClass) {
        boolean valid=true;
        if(schoolClass==null || schoolClass.isEmpty()){
            valid=false;
        }
        try{
            Integer.parseInt( schoolClass.charAt(0)+"");
        } catch (NumberFormatException e) {
            valid = false;
        }
        if(!valid){
            throw new IllegalArgumentException("Klasse nicht null oder leer sein oder muss mit einer Zahl beginnen");
        }
        this.schoolClass = schoolClass;
    }

    public void setSubjects(List subjects) {
        if(subjects==null || subjects.size()<3){
            throw new IllegalArgumentException("Subjects dürfen nicht leer sein");
        }
        this.subjects = subjects;
    }

    public float average(){
        Iterator it = subjects.iterator();
        float sum = 0;
        while (it.hasNext()){
            int mark=((Subject)it.next()).getMark();
            if(mark==0){
                return -1;
            }
            sum+=mark;
        }
        return sum/subjects.size();
    }

    public List<Subject> bestSubjects(){
        Iterator it = subjects.iterator();
        int besteNote=5;
        Subject save;
        while(it.hasNext()){
            save=(Subject)it.next();
            if(save.getMark()!=0 && save.getMark()<besteNote) {
                besteNote = save.getMark();
            }
        }

        it=subjects.iterator();
        List<Subject> bestSubjects=new ArrayList<Subject>();
        while(it.hasNext()){
            save=(Subject)it.next();
            if(save.getMark()==besteNote){
                bestSubjects.add(save);
            }
        }

        return bestSubjects;
    }

    public Subject delSubject(Subject subject) {
        Iterator it = subjects.iterator();
        Subject save;
        while(it.hasNext()){
            save=(Subject)it.next();
            if(save.equals(subject)){
                it.remove();
                return save;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", schoolClass='" + schoolClass + '\'' +
                ", subjects=" + subjects +
                '}';
    }

    public String getKey(){
        return name+schoolClass;
    }
}
