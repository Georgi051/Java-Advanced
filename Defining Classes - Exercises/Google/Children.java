package DefiningClassesExercise.Google;

public class Children {
    private String name;
    private String birthday;

    public Children(String cName, String cBirthDay) {
        this.name = cName;
        this.birthday = cBirthDay;
    }

    @Override
    public String toString() {
        return String.format("%s %s",this.name,this.birthday);
    }
}
