KID3
====

# About the Project

**KID** is a small, java-based ID3 library which supports reading **ID3v1** and **ID3v2** tags from MP3 files. As i needed this library as part of an MP3 player, currently only reading is supported, but there may be write-support in the future ;)

# How to use

Just clone the repository, import the project in **eclipse** and build a **jar**-file which you can use in your own projects.

# Example

```
File file = new File("/path/to/file.mp3");

// auto-detect ID3v2 or ID3v1 as fallback
ID3 id3 = new ID3(file);
if ( id3.isOK() ) {
  System.out.println( id3.getArtist() );
}

// use only ID3v2
ID3v2 id3v2 = new ID3v2(file);
if ( id3v2.isOK() ) {
  System.out.println( id3v2.getArtist() );
}
```
