import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class ImageCustom {
    public Image imageReturn() throws IOException {
        Image image;
        InputStream bis = getClass().getResourceAsStream("/resources/icon/icon.png");
        assert bis != null;
        image = ImageIO.read(bis);

        return image;
    }
}
