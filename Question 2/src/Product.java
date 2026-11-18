public class Product implements IProduct {
double productPrice;

    public Product(double productPrice) {
this.productPrice=productPrice;
}
public void setPrductPrice(double productPrice){
    this.productPrice=productPrice;
}

    @Override
    public double GetVat() {
        return productPrice*0.15;
    }

    @Override
    public double GetCommission() {
        return productPrice*0.05;
    }

    @Override
    public double GetTotal() {
        return productPrice+GetVat()+GetCommission();
    }
}
