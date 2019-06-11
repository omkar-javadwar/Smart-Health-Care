package com.example.shp;

class Zero {

    public String name,gender,speciality,address,year,phone,email;
    public Zero() {
    }

    public Zero(String name, String gender, String specility, String address, String year, String phone,String email) {
        this.name = name;
        this.gender = gender;
        this.speciality = speciality;
        this.address = address;
        this.year = year;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getGen(){return gender;}

    public String getSpe(){ return speciality;}

    public String getAdd(){return  address;}

    public String getExp(){return year;}

    public String getPh(){return phone;}

    public String getEmail(){return email;}
}
