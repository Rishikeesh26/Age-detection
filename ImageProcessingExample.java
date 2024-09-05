import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.CvType;
import org.opencv.core.Scalar;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.MatOfPoint2f;
import org.opencv.features2d.Features2d;

import java.util.ArrayList;
import java.util.List;

public class ImageProcessingExample {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        // Load the image
        String inputImagePath = "path/to/your/image.jpg";
        Mat image = Imgcodecs.imread(inputImagePath);

        if (image.empty()) {
            System.out.println("Could not load image.");
            return;
        }

        // Convert to grayscale
        Mat grayImage = new Mat();
        Imgproc.cvtColor(image, grayImage, Imgproc.COLOR_BGR2GRAY);

        // Apply Gaussian blur
        Mat blurredImage = new Mat();
        Imgproc.GaussianBlur(grayImage, blurredImage, new Size(15, 15), 0);

        // Save the processed image
        String outputImagePath = "path/to/save/processed_image.jpg";
        boolean isSuccess = Imgcodecs.imwrite(outputImagePath, blurredImage);

        if (isSuccess) {
            System.out.println("Image processed and saved successfully.");
        } else {
            System.out.println("Failed to save the image.");
        }
    }
}
