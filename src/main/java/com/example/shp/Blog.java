package com.example.shp;

class Blog {
    String date,name,address,phone,email,compliment,complaint;
    public Blog() {
    }

    // getters

    // setters

    @Override
    public String toString() {
        return "Date : "+this.date +"\n from, \n" + this.address + "\n Name : " + this.name + "\n Phone : " + this.phone +
                "\n Email : " + this.email + "\n Compliment : "+ this.compliment + "\n Complaint : "+this.complaint;
    }
}
