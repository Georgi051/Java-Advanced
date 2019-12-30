package DefiningClassesExercise.Google;

public class Parents {
    private String name;
    private String birthday;

    public Parents(String parentsName, String birthDay) {
        this.name = parentsName;
        this.birthday = birthDay;
    }

    @Override
    public String toString() {
        return String.format("%s %s",this.name,this.birthday);
    }
}
