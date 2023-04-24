public class js {

    public static void main(String[] args) {
        var image = new SimpleImage("astrachan.jpg");

        var height = someImage.getHeight();
        for (var pixel of someImage.values()) {
            if (pixel.getY() >= height - 10) {
                pixel.setRed(0);
                pixel.setGreen(0);
                pixel.setBlue(0);
            }
        }

        print(image);
    }

}
