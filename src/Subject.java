import java.util.Objects;

public class Subject {
    private int mark;
    private String name;

    public Subject(int mark, String name) {
        setMark(mark);
        setName(name);
    }

    public void setMark(int mark) {
        if(mark<0 || mark>5){
            throw new IllegalArgumentException();
        }
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

    public void setName(String name) {
        if(name==null || name.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return "----------\nSubject: \n Mark="+mark+"\nName="+name+"\n----------";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return mark == subject.mark && Objects.equals(name, subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark, name);
    }
}
