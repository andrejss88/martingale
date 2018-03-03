import java.util.Random;

public enum BetColor {

    RED(0), BLACK(1);

    BetColor(int color) {
        this.color = color;
    }

    private int color;

    public static int getRandomColor(){
        return BetColor.values()[new Random().nextInt(BetColor.values().length)].color;
    }

    public int getColor() {
        return color;
    }
}
