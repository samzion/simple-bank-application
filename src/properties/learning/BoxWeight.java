package properties.learning;

public class BoxWeight extends Box {
    double weight;

    //@Override
    void greetingWe(){
        System.out.println("Hey, I am in BoxWeight class. Greetings!");
    }
    public BoxWeight(){
        this.weight = -1;
    }

    public BoxWeight(double l, double h, double w, double weight) {
        super(l, h, w);
        this.weight = weight;
    }

    public BoxWeight(Box old, double weight) {
        super(old);
        this.weight = weight;
    }

    public BoxWeight( BoxWeight other){
        super(other);
    }
}
