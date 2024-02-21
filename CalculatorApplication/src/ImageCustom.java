import java.io.*;
import javax.imageio.ImageIO;
import java.awt.*;
class ImageCustom {
    public Image imageReturn() throws IOException {
        Image image;
        InputStream bis = getClass().getResourceAsStream("/resources/icon/icon.png");
        assert bis != null;
        image = ImageIO.read(bis);

        return image;
    }
}