package li.kazu.java.audio.id3;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

/**
 * represents one image within the ID3 tag
 * @author kazu
 *
 */
public class ID3Image {

	/** the file the image is contained in */
	private File file;
	
	/** the first byte of the image */
	private int byteFrom;
	
	/** the byte length of the image */
	private int byteLength;

	
	/** create a new ID3 Image */
	protected ID3Image(File file, int byteFrom, int byteLength) {
		this.file = file;
		this.byteFrom = byteFrom;
		this.byteLength = byteLength;
	}
	
	/**
	 * get the cover image as byte array.<br>
	 * this will open the MP3-File and read the image-part
	 * @return the cover-image as byte[]
	 */
	public byte[] getImageBytes() {
		
		try {
			
			// open MP3 file
			FileInputStream fis = new FileInputStream(file);
			DataInputStream dis = new DataInputStream(fis);
			
			// seek to image-position and read it
			byte[] buf = new byte[byteLength];
			dis.skip(byteFrom);
			dis.readFully(buf);
			
			// cleanup
			dis.close();
			
			// see http://www.id3.org/id3v2.3.0 (4.15)
			// the binary data of the pictures follows after 0x00 has appeared twice
			// (what we do here, is skip the picture's metadata)
			int cnt = 0, i;
			for (i = 0; i < buf.length && cnt < 2; ++i) {
				if (buf[i] == 0) {++cnt;}
			}
			
			// remove metadata
			byte[] img = new byte[buf.length - i];
			System.arraycopy(buf, i, img, 0, buf.length - i);
						
			// return
			return img;
			
		} catch (Exception e) {e.printStackTrace();}
		
		return null;
		
	}
	
	/**
	 * get the buffered image.
	 * this will open the MP3-File and read the image-part
	 * @return the BufferedImage or null if an error occured
	 */
	public BufferedImage getImage() {
		
		try {
			
			byte[] buf = getImageBytes();
			
			// return result image
			if (buf != null) {
				return getPicture(buf);
			} else {
				return null;
			}
			
		} catch (Exception e) {e.printStackTrace();}
		
		return null;
		
	}
	
	
	/** get the picture out of the given data array */
	private BufferedImage getPicture(byte[] data) {
				
		// read the picture
		try {
			return ImageIO.read(new ByteArrayInputStream(data));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
}
