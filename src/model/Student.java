package model;

import java.io.Serializable;

public class Student  implements Serializable {
    private String msv;
    private String fullName;
    private String eag;
    private String male;
    private String address;
    String avg;

    public Student(String msv, String fullName, String eag, String male, String address, String avg) {
        this.msv = msv;
        this.fullName = fullName;
        this.eag = eag;
        this.male = male;
        this.address = address;
        this.avg = avg;
    }

    public Student() {
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEag() {
        return eag;
    }

    public void setEag(String eag) {
        this.eag = eag;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        return "Student{" +
                "msv='" + msv + '\'' +
                ", fullName='" + fullName + '\'' +
                ", eag='" + eag + '\'' +
                ", male='" + male + '\'' +
                ", address='" + address + '\'' +
                ", avg='" + avg + '\'' +
                '}';
    }
}
