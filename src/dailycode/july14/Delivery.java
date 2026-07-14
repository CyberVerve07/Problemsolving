package dailycode.july14;

class Delivery {

    public Post doDelivery() {
        System.out.println("Delivery do delivery:");
        return new Post();
    }
}

//Covarient return type L:;

class OneDayDelivery extends Delivery {

    @Override
    public SpeedPost doDelivery() {
        System.out.println("One day Delivery:");
        return new SpeedPost();
    }
}