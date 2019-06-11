package com.example.shp;

class Clinic{

    String name,speciality,address,year,phone,email;
    public Clinic() {
    }

    @Override
    public String toString() {
        return " Name : "+ this.name +"\n Address: " + this.address + "\n Speciality : " + this.speciality +
                "\n Phone : " + this.phone + "\n Email : " + this.email + "\n Year of Foundation : " +this.year;
    }

}