package Netflix;

public class Subscription {
    public String planName;
    public double price;
    public String maxScreen;
    public String videoQuality;

    public Subscription(String planName, double price, String maxScreen, String videoQuality) {
        this.planName = planName;
        this.price = price;
        this.maxScreen = maxScreen;
        this.videoQuality = videoQuality;
    }

    public void showDetails() {
        System.out.println("Your Details are---------------------------- ");
        System.out.println("Your Plan is  ::" + this.planName);
        System.out.println("Subscription Price is ::" + this.price);
        System.out.println("Maximum Screen size is ::" + this.maxScreen);
        System.out.println("Video Quality is ::" + this.videoQuality);
    }
}
