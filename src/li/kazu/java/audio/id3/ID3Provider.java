package li.kazu.java.audio.id3;


/**
 * 
 * both ID3v2 and ID3v1 must at least
 * provide these attributes
 * 
 * @author kazu
 *
 */
public interface ID3Provider {

	/** the file contained ID3 information */
	public boolean isOK();

	
	/** get the artist of the song */
	public String getArtist();
	
	/** get the title of the song */
	public String getTitle();
	
	/** get the album/single of the song */
	public String getAlbum();
	
	/** get the year the album/single was released */
	public String getYear();
	
	/** get additional comments */
	public String getComment();
	
	/** get the genre of the song */
	public String getGenre();
	
	/** get the cover image (if any) */
	public ID3Image getCover();

}