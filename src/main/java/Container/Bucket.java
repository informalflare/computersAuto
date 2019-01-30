package Container;

import Models.Computer;

public class Bucket {

    static Computer computer;
    static Computer computerBefore;

    public static Computer getComputerbefore() {
        return computerBefore;
    }

    public static void setComputerbefore(Computer computerbefore) {
        Bucket.computerBefore = computerbefore;
    }



    public static  Computer getComputer() {
        return computer;
    }

    public static void setComputer(Computer incomingComputer) {
        computer = incomingComputer;
    }

}
