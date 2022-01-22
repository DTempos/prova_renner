package core;

import java.awt.*;
import java.io.File;

import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import static org.monte.media.VideoFormatKeys.*;

public class GravarVideo {

	private ScreenRecorder screenRecorder;

	public void IniciarGravacao() throws Exception {

		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();

		this.screenRecorder = new ScreenRecorder(gc, new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
						CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
						Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(60)),
				null);

		this.screenRecorder.start();

	}

	public void startRecording(String path) throws Exception {

		// setar configura��es gr�ficas
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();

		// initialize the screen recorder:
		// - default graphics configuration
		// - full screen recording
		// - record in AVI format
		// - 15 frames per second
		// - black mouse pointer
		// - no audio
		// - save capture to predefined location

		this.screenRecorder = new ScreenRecorder(gc, gc.getBounds(),
				new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
						CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
						Rational.valueOf(10), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 30),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
				null, new File(path));
		this.screenRecorder.start();
	}

	public void FinalizarGravacao() throws Exception {
		Thread.sleep(3000);
		this.screenRecorder.stop();
	}
}
