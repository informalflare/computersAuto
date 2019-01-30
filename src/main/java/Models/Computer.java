package Models;

import org.apache.commons.lang3.RandomStringUtils;

public class Computer {

    public Computer() {
    }

    public Computer(String name, String date, String date2, String company) {
        this.name = name;
        this.date = date;
        this.date2 = date2;
        this.company = company;

    }

    String name;
    String date;
    String date2;
    String company;




    public boolean equals(Computer comp){

        if(!comp.getName().equals(this.name)) return false;
        if(!comp.getDate().equals(this.date)) return false;
        if(!comp.getDate2().equals(this.date2)) return false;
        if(!comp.getCompany().equals(this.company)) return false;
        return true;

    }



    @Override
    public String toString() {
        return name+" "+date+" "+date2+" "+company+"\n";

    }

    public String getName() {
        return name;
    }

    public Computer setName(String name) {
        this.name = name;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Computer setDate(String date) {
        this.date = date;
        return this;
    }

    public String getDate2() {
        return date2;
    }

    public Computer setDate2(String date2) {
        this.date2 = date2;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public Computer setCompany(String company) {
        this.company = company;
        return this;
    }

    public static Computer getRandomComputer() {
        Computer comp = new Computer();
        comp.setName(RandomStringUtils.randomAlphabetic(10));
        //TODO create random data generator with validators (maybe api to get list of companies)
        comp.setDate("1989-10-20");
        comp.setDate2("2000-10-20");
        comp.setCompany("Nintendo");  //needs a list of companies to pull from
        return comp;
    }


    public static Computer getRandomComputerDifferentFrom(Computer computer){
        //TODO create a valid functionality
        return Computer.getRandomComputer();
    }

}
