package li.kazu.java.audio.id3;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * read ID3 information using ID3v2
 * 
 * @author kazu
 *
 */
public class ID3v2 implements ID3Provider {

	/* settings */
	private static final String V2_ARTIST = "TP1";
	private static final String V2_TITLE = "TT2";
	private static final String V2_ALBUM = "TAL";
	private static final String V2_YEAR = "TYE";
	private static final String V2_GENRE = "TCO";
	
	private static final String V3_ARTIST = "TPE1";
	private static final String V3_TITLE = "TIT2";
	private static final String V3_ALBUM = "TALB";
	private static final String V3_YEAR = "TYER";
	private static final String V3_GENRE = "TCON";
	private static final String V3_IMAGE = "APIC";
	
	
	
	/* attributes */
	private boolean			isOK = false;

	private String			title = "";
	private String			artist = "";
	private String			album = "";
	private String			year = "";
	private String			comment = "";
	private String			genre = "";
	private ID3Image		cover = null;

	private File file;
	

	/** create ID3v2 reader for the given file */
	public ID3v2(File file) {
		this.file = file;
		read();
	}


	/* lesen */
	private void read() {
		
		try {

			FileInputStream iss = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(iss);
			
			// buffer for "ID3", version, flags and header size
			byte[] data = new byte[10];
			bis.read(data);
			
			// check the file's header for "ID3"
			if (!(new String(data, 0, 3)).equals("ID3")) {bis.close(); return;}

			// now read: 2 bytes: version, 1 byte: flags
			int version = data[3];

			// calculate the total ID3v2 size
			int tagSize = data[9] + (data[8] << 8) + (data[7] << 16) + (data[6] << 32);

			// read the whole header
			data = new byte[tagSize];
			bis.read(data);

			// now analzye the data
			analyze(version, data);

			// cleanup
			bis.close();

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/** read all tags assuming file is stored in ID3v2x where x = version */
	private void analyze(int version, byte[] data) {

		// ID3v2.2
		if (version == 2) {
			
			artist = getTag(data, V2_ARTIST);
			title = getTag(data, V2_TITLE);
			album = getTag(data, V2_ALBUM);
			year = getTag(data, V2_YEAR);
			genre = getTag(data, V2_GENRE);
			
		// ID3v2.3 and ID3v2.4
		} else {
			
			artist = getTag(data, V3_ARTIST);
			title = getTag(data, V3_TITLE);
			album = getTag(data, V3_ALBUM);
			year = getTag(data, V3_YEAR);
			genre = getTag(data, V3_GENRE);
			getTag(data, V3_IMAGE);

		}

		// cleanup the genre (if needed) and check if OK
		genre = Genres.getGenreByString(genre);
		isOK = (!title.isEmpty() || !artist.isEmpty());

	}

	

	/**
	 * get the tag by the given name out of the given byte[]
	 * @param data the data to get the tag from
	 * @param name the TAG to read
	 * @return the read tag in the correct charset (or null if picture (APIC) was requested
	 */
	private String getTag(byte[] data, String name) {

		try {
		
			// get the start position of the tag we searched for
			int pos = ByteHelper.indexOf(data, name);
						
			// tag not set? => return empty string
			if (pos == -1) {return "";}

			int charset, pos2, pos3, size;

			// ID3v2.2
			if (name.length() == 3) {
				
				pos2 = pos + 3;
				pos3 = pos + 7;
				size = getInt3(data, pos2);
				charset = data[pos3-1];
				
			// ID3V2.3 and ID3v2.4
			} else {
				
				pos2 = pos + 4;
				pos3 = pos + 11;
				size = getInt4(data, pos2);
				charset = data[pos3-1];
				if (name == V3_IMAGE) {charset = 9;}
				
			}

			// convert string using the correct charset
			switch (charset) {
				
				case 0:	return new String(data, pos3, size-1, "ISO-8859-1").trim();
				
				case 1: return new String(data, pos3, size-1, "UTF-16").trim();
				
				case 2: return new String(data, pos3, size-1, "UTF-16BE").trim();
				
				case 3: return new String(data, pos3, size-1, "UTF-8").trim();
				
				case 9:
					int headerSize = 10;
					cover = new ID3Image(file, pos3+headerSize, size-1);
					//byte[] outImg = new byte[size-1];
					//System.arraycopy(data, pos3, outImg, 0, size-1);
					//bImg = getPicture(outImg);
					return null;
				
				default: return "";
			
			}


		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}



	
	/** convert 3 bytes into an int */
	private int getInt3(byte[] arr, int start) {
		return ((arr[start] & 0xFF) << 16) + ((arr[start+1] & 0xFF) << 8) + ((arr[start+2] & 0xFF) << 0);
	}
	
	/** convert 4 bytes into an int */
	private int getInt4(byte[] arr, int start) {
		return ((arr[start] & 0xFF) << 24) + ((arr[start+1] & 0xFF) << 16) + ((arr[start+2] & 0xFF) << 8) + ((arr[start+3] & 0xFF) << 0);
	}
	


	


	@Override
	public boolean isOK()           {return isOK;}

	@Override
	public String getArtist()       {return artist;}
	
	@Override
	public String getTitle()        {return title;}
	
	@Override
	public String getAlbum()        {return album;}
	
	@Override
	public String getYear()         {return year;}
	
	@Override
	public String getComment()      {return comment;}
	
	@Override
	public String getGenre()        {return genre;}

	@Override
	public ID3Image getCover()		{return cover;}

}