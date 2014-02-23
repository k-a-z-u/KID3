package li.kazu.java.audio.id3;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;

/**
 * read ID3 information using ID3v1
 * 
 * @author kazu
 *
 */
public class ID3v1 implements ID3Provider {

	/* attributes */
	private boolean		isOK = false;

	private String		title = "";
	private String		artist = "";
	private String		album = "";
	private String		year = "";
	private String		comment = "";
	private int			genreID = 0;
	private String		genre = "";


	/** create ID3v1 reader for the given file */
	public ID3v1(File file) {
		read(file);
	}


	/** read the content to check */
	private void read(File file) {
		try {

			byte[] data = new byte[128];
			FileInputStream is = new FileInputStream(file);
			
			// skip to the last 128 bytes
			long start = is.getChannel().size() - 128;
			is.skip(start);

			// and read these 128 bytes
			is.read(data);

			// now check the content
			analyze(data);

			// cleanup
			is.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/** check the content of the 128 bytes read */
	private void analyze(byte[] data) throws UnsupportedEncodingException {

		// read content into an ASCII-string
		String s = new String(data, "US-ASCII");
		isOK = false;
		
		// check if we have an ID3v1-tag here
		if (s.startsWith("TAG")) {
			
			title = s.substring(3, 33).trim();
			artist = s.substring(33, 63).trim();
			album = s.substring(63, 93).trim();
			year = s.substring(93, 97).trim();
			comment = s.substring(97, 127).trim();
			genreID = (data[127] >= 0) ? (data[127]) : (data[127] + 256);
			genre = Genres.getGenreByID(genreID);

			isOK = (!title.isEmpty() || !artist.isEmpty());
			
		}

	}



	/* getter */
	public boolean isOK()           {return isOK;}

	public String getArtist()       {return artist;}
	public String getTitle()        {return title;}
	public String getAlbum()        {return album;}
	public String getYear()         {return year;}
	public String getComment()      {return comment;}
	public String getGenre()        {return genre;}
	public ID3Image getCover()		{return null;}

}
