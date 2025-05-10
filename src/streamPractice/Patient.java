package streamPractice;

public class Patient {
    private String name;
    private int age;
    private String gender;
    private String bloodType;

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private double bill;

    public Patient(String name, int age, String gender, String bloodType, double bill) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.bloodType = bloodType;
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "Patient{" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", bill=" + bill +
                '}';
    }
}
