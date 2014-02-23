package li.kazu.java.audio.id3;

/**
 * contains a list of ID3v1 Genres
 * 
 * @author kazu
 *
 */
class Genres {

	/** genre-id to genre mapping */
	private static final String[] ID_TO_GENRE = new String[256];

	/** create the mapping */
	static {

		ID_TO_GENRE[0] = "Blues";
		ID_TO_GENRE[1] = "Classic Rock";
		ID_TO_GENRE[2] = "Country";
		ID_TO_GENRE[3] = "Dance";
		ID_TO_GENRE[4] = "Disco";
		ID_TO_GENRE[5] = "Funk";
		ID_TO_GENRE[6] = "Grunge";
		ID_TO_GENRE[7] = "Hip-Hop";
		ID_TO_GENRE[8] = "Jazz";
		ID_TO_GENRE[9] = "Metal";
		ID_TO_GENRE[10] = "New Age";
		ID_TO_GENRE[11] = "Oldies";
		ID_TO_GENRE[12] = "Other";
		ID_TO_GENRE[13] = "Pop";
		ID_TO_GENRE[14] = "R&B";
		ID_TO_GENRE[15] = "Rap";
		ID_TO_GENRE[16] = "Reggae";
		ID_TO_GENRE[17] = "Rock";
		ID_TO_GENRE[18] = "Techno";
		ID_TO_GENRE[19] = "Industrial";
		ID_TO_GENRE[20] = "Alternative";
		ID_TO_GENRE[21] = "Ska";
		ID_TO_GENRE[22] = "Death Metal";
		ID_TO_GENRE[23] = "Pranks";
		ID_TO_GENRE[24] = "Soundtrack";
		ID_TO_GENRE[25] = "Euro-Techno";
		ID_TO_GENRE[26] = "Ambient";
		ID_TO_GENRE[27] = "Trip-Hop";
		ID_TO_GENRE[28] = "Vocal";
		ID_TO_GENRE[29] = "Jazz+Funk";
		ID_TO_GENRE[30] = "Fusion";
		ID_TO_GENRE[31] = "Trance";
		ID_TO_GENRE[32] = "Classical";
		ID_TO_GENRE[33] = "Instrumental";
		ID_TO_GENRE[34] = "Acid";
		ID_TO_GENRE[35] = "House";
		ID_TO_GENRE[36] = "Game";
		ID_TO_GENRE[37] = "Sound Clip";
		ID_TO_GENRE[38] = "Gospel";
		ID_TO_GENRE[39] = "Noise";
		ID_TO_GENRE[40] = "Alternative Rock";
		ID_TO_GENRE[41] = "Bass";
		ID_TO_GENRE[42] = "Soul";
		ID_TO_GENRE[43] = "Punk";
		ID_TO_GENRE[44] = "Space";
		ID_TO_GENRE[45] = "Meditative";
		ID_TO_GENRE[46] = "Instrumental Pop";
		ID_TO_GENRE[47] = "Instrumental Rock";
		ID_TO_GENRE[48] = "Ethnic";
		ID_TO_GENRE[49] = "Gothic";
		ID_TO_GENRE[50] = "Darkwave";
		ID_TO_GENRE[51] = "Techno-Industrial";
		ID_TO_GENRE[52] = "Electronic";
		ID_TO_GENRE[53] = "Pop-Folk";
		ID_TO_GENRE[54] = "Eurodance";
		ID_TO_GENRE[55] = "Dream";
		ID_TO_GENRE[56] = "Southern Rock";
		ID_TO_GENRE[57] = "Comedy";
		ID_TO_GENRE[58] = "Cult";
		ID_TO_GENRE[59] = "Gangsta";
		ID_TO_GENRE[60] = "Top 40";
		ID_TO_GENRE[61] = "Christian Rap";
		ID_TO_GENRE[62] = "Pop/Funk";
		ID_TO_GENRE[63] = "Jungle";
		ID_TO_GENRE[64] = "Native US";
		ID_TO_GENRE[65] = "Cabaret";
		ID_TO_GENRE[66] = "New Wave";
		ID_TO_GENRE[67] = "Psychadelic";
		ID_TO_GENRE[68] = "Rave";
		ID_TO_GENRE[69] = "Showtunes";
		ID_TO_GENRE[70] = "Trailer";
		ID_TO_GENRE[71] = "Lo-Fi";
		ID_TO_GENRE[72] = "Tribal";
		ID_TO_GENRE[73] = "Acid Punk";
		ID_TO_GENRE[74] = "Acid Jazz";
		ID_TO_GENRE[75] = "Polka";
		ID_TO_GENRE[76] = "Retro";
		ID_TO_GENRE[77] = "Musical";
		ID_TO_GENRE[78] = "Rock & Roll";
		ID_TO_GENRE[79] = "Hard Rock";
		ID_TO_GENRE[80] = "Folk";
		ID_TO_GENRE[81] = "Folk-Rock";
		ID_TO_GENRE[82] = "National Folk";
		ID_TO_GENRE[83] = "Swing";
		ID_TO_GENRE[84] = "Fast Fusion";
		ID_TO_GENRE[85] = "Bebob";
		ID_TO_GENRE[86] = "Latin";
		ID_TO_GENRE[87] = "Revival";
		ID_TO_GENRE[88] = "Celtic";
		ID_TO_GENRE[89] = "Bluegrass";
		ID_TO_GENRE[90] = "Avantgarde";
		ID_TO_GENRE[91] = "Gothic Rock";
		ID_TO_GENRE[92] = "Progressive Rock";
		ID_TO_GENRE[93] = "Psychedelic Rock";
		ID_TO_GENRE[94] = "Symphonic Rock";
		ID_TO_GENRE[95] = "Slow Rock";
		ID_TO_GENRE[96] = "Big Band";
		ID_TO_GENRE[97] = "Chorus";
		ID_TO_GENRE[98] = "Easy Listening";
		ID_TO_GENRE[99] = "Acoustic";
		ID_TO_GENRE[100] = "Humour";
		ID_TO_GENRE[101] = "Speech";
		ID_TO_GENRE[102] = "Chanson";
		ID_TO_GENRE[103] = "Opera";
		ID_TO_GENRE[104] = "Chamber Music";
		ID_TO_GENRE[105] = "Sonata";
		ID_TO_GENRE[106] = "Symphony";
		ID_TO_GENRE[107] = "Booty Bass";
		ID_TO_GENRE[108] = "Primus";
		ID_TO_GENRE[109] = "Porn Groove";
		ID_TO_GENRE[110] = "Satire";
		ID_TO_GENRE[111] = "Slow Jam";
		ID_TO_GENRE[112] = "Club";
		ID_TO_GENRE[113] = "Tango";
		ID_TO_GENRE[114] = "Samba";
		ID_TO_GENRE[115] = "Folklore";
		ID_TO_GENRE[116] = "Ballad";
		ID_TO_GENRE[117] = "Power Ballad";
		ID_TO_GENRE[118] = "Rhytmic Soul";
		ID_TO_GENRE[119] = "Freestyle";
		ID_TO_GENRE[120] = "Duet";
		ID_TO_GENRE[121] = "Punk Rock";
		ID_TO_GENRE[122] = "Drum Solo";
		ID_TO_GENRE[123] = "Acapella";
		ID_TO_GENRE[124] = "Euro-House";
		ID_TO_GENRE[125] = "Dance Hall";
		ID_TO_GENRE[126] = "Goa";
		ID_TO_GENRE[127] = "Drum & Bass";
		ID_TO_GENRE[128] = "Club-House";
		ID_TO_GENRE[129] = "Hardcore";
		ID_TO_GENRE[130] = "Terror";
		ID_TO_GENRE[131] = "Indie";
		ID_TO_GENRE[132] = "BritPop";
		ID_TO_GENRE[133] = "Negerpunk";
		ID_TO_GENRE[134] = "Polsk Punk";
		ID_TO_GENRE[135] = "Beat";
		ID_TO_GENRE[136] = "Christian Gangsta Rap";
		ID_TO_GENRE[137] = "Heavy Metal";
		ID_TO_GENRE[138] = "Black Metal";
		ID_TO_GENRE[139] = "Crossover";
		ID_TO_GENRE[140] = "Contemporary Christian";
		ID_TO_GENRE[141] = "Christian Rock";
		ID_TO_GENRE[142] = "Merengue";
		ID_TO_GENRE[143] = "Salsa";
		ID_TO_GENRE[144] = "Trash Metal";
		ID_TO_GENRE[145] = "Anime";
		ID_TO_GENRE[146] = "Jpop";
		ID_TO_GENRE[147] = "Synthpop";

	}

	/** get genre-string by id */
	public static String getGenreByID(int genreID) {
		if (genreID < 0 || genreID > 255) {return "";}
		return (ID_TO_GENRE[genreID] != null) ? (ID_TO_GENRE[genreID]) : ("");
	}


	/** get genre by string that may be an ID (number) or already the genre */
	public static String getGenreByString(String genre) {

		// if "(123)" convert to, "123"
		if (genre.startsWith("(") && genre.endsWith(")")) {
			genre = genre.substring(1, genre.length() - 1);
		}

		try {

			// if we have a number here, get teh genre by ID */
			int id = Integer.parseInt(genre);
			return getGenreByID(id);

		} catch (NumberFormatException e) {

			// wasn't a number but the genre itself => cleanup
			if (genre == null) {
				return "";
			} else {
				return genre.replaceAll("(\\()([0-9]*)(\\))", "").trim();
			}

		}

	}

}