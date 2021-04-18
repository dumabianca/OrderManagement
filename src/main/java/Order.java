public class Order {
    private int id;
    private int client;
    private int product;
    private int  quantity;
    public Order(int id, int client, int product, int quantity)
    {
        this.id=id;
        this.client=client;
        this.product=product;
        this.quantity=quantity;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String toString()
    {
        return "order id: "+id+"  "+"client id: "+ client+"  "+"product id: "+product+"   "+"quntity"+quantity;
    }
}
