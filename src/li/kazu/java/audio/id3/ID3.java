package li.kazu.java.audio.id3;

import java.io.File;

/**
 * try to get ID3 information<br>
 * first try ID3v2, if not successful try ID3v1
 * 
 * @author kazu
 *
 */
public class ID3 implements ID3Provider {

	/* attributes */
	private boolean			isOK = false;
	private String			title = "";
	private String 			artist = "";
	private String			album = "";
	private String			year = "";
	private String			comment = "";
	private String			genre = "";
	private ID3Image		cover = null;
	

	/** create ID3 reader for the given fill (this will try ID3v2 first, then ID3v1) */
	public ID3(File file) {

		// try V2
		ID3Provider dataSrc = new ID3v2(file);

		// failed? => try v1
		if (!dataSrc.isOK()) {dataSrc = new ID3v1(file);}

		// ok? => set values
		if (dataSrc.isOK()) {
			isOK = true;
			readTags(dataSrc);
		}

		dataSrc = null;
		
	}


	/* tags einlesen */
	private void readTags(ID3Provider dataSrc) {
		artist = dataSrc.getArtist();
		title = dataSrc.getTitle();
		album = dataSrc.getAlbum();
		year = dataSrc.getYear();
		comment = dataSrc.getComment();
		genre = dataSrc.getGenre();
		cover = dataSrc.getCover();
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
	public ID3Image getCover() 		{return cover;}

	@Override
	public String toString()		{return artist + " - " + title;}
	
}
