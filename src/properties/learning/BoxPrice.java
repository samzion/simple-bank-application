package properties.learning;

public class BoxPrice extends BoxWeight{
    double cost;

    BoxPrice(){
        super();
        this.cost = -1;
    }

    public BoxPrice(double cost) {
        this.cost = cost;
    }

    public BoxPrice(double l, double h, double w, double weight, double cost) {
        super(l, h, w, weight);
        this.cost = cost;
    }

    public BoxPrice(BoxWeight other, double cost) {
        super(other);
        this.cost = cost;
    }

    BoxPrice(BoxWeight other ){
        super(other);
        this.cost = -1;
    }

    BoxPrice(BoxPrice other){
        super(other);
        this.cost = other.cost;
    }
}
