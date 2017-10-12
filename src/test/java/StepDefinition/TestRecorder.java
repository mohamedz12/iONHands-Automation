package StepDefinition;
import org.monte.media.math.Rational;
import org.monte.media.Format;
import org.monte.screenrecorder.ScreenRecorder;
import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;
import java.awt.AWTException;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.IOException;
import java.util.Locale;

public class TestRecorder {
	public static ScreenRecorder sr;
	public static void StartTestRecording() throws IOException, AWTException {
		GraphicsConfiguration gc = GraphicsEnvironment
		        .getLocalGraphicsEnvironment()
		        .getDefaultScreenDevice()
		        .getDefaultConfiguration();
	
		TestRecorder.sr = new ScreenRecorder(gc,
		        new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
		        new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
		        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
		        DepthKey, (int)24, FrameRateKey, Rational.valueOf(15),
		        QualityKey, 1.0f,
		        KeyFrameIntervalKey, (int) (15 * 60)),
		        new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,"black",
		        FrameRateKey, Rational.valueOf(30)),
		        null);
		  sr.start();
	}
		
	public static void EndTestRecording() throws IOException,AWTException{
	      sr.stop();
	}
}
