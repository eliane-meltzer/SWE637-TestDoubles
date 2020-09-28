package utils;

public class Customer {
    private String name;
    private String membership; // Platinum , gold , silver and blue
    private Rank rank;

    // determined by reservation service based on ranking service
    private int boardingGroup = 0;
    private int seat = 0;


    public Customer(String name,String membership) {
        this.name = name;
        this.membership = membership;


    }
    public Customer(String name) {
        this.name = name;
        this.membership = "Blue";
    }

    public void setRank(double rank) {
        this.rank = new Rank(rank);
    }

    public Rank getRank() { return rank; }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getSeat() { return seat; }

    public int getBoardingGroup() {
        return boardingGroup;
    }

    public void setBoardingGroup(int group) {
        this.boardingGroup = group;
    }

    public String getName() {
        return name;
    }

    public String getMembership() { return membership; }


}
