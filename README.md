# cs3200-final-project

<img width="664" alt="Screen Shot 2021-12-05 at 10 36 36 PM" src="https://user-images.githubusercontent.com/82342205/145726177-0719a4ce-c62c-46d1-8a6a-e096402a253f.png">

P3 Final Project
Group 17     CS3200    December 14, 2021
Ananda Francis, Hannah Lauterwasser, Jessica Luo, and Kelly Ward

#Project
#Problem Statement
Our group sought to solve the problem of creating and maintaining thoughtful playlists.  We realized through our own use of music streaming platforms that we do not always have a clear reasoning as to why we add certain songs to our playlists.  We thought that this could be an interesting feature to include, as it could help the user make more thoughtful decisions when creating playlists.  In addition, this feature would allow the user to look back on their playlists and song choices to understand why they have curated a playlist a certain way.  Our group also wanted to ensure that the playlists created included as much information about the songs added as possible, such as the album the song is from and the artist who created it, to help the user keep track of their music.

#Solution Statement
Through this project, we have created a database to clearly keep track of a user’s playlists.  Our problem, which was wanting the user to have the ability to input a reason for each song addition to a playlist, was solved through the use of a PlaylistAdds table.  PlaylistAdds includes the rationale as to why a user added a particular song to a certain playlist.  The user has playlists with songs, and each song also is from an album and was created by a certain artist.  

#User
The typical user that would benefit from our solution could be any user of Spotify, Apple Music, or other streaming platforms.  This user might want to carefully create a playlist that fits their mood at a given time or caters to those around them, so they might want to have a rationale for each song to ensure they have created the playlist that fits their mood.  For example, if they are creating a playlist to play for a group of friends, they might want to include songs their friends enjoy, and each song addition could have the rationale of their friend’s name.  This ensures that the playlist would cater to everyone’s music taste.  The user might also want to add songs throughout certain parts of their year (such as during birthdays, holidays, and more), and the rationale will allow them to remember the songs that were played during that specific memory, providing the user with a playlist to look back on.  

#Domain Objects
The domain objects we have included include playlist, playlist adds, song, album, and artist.  The playlist table includes information such as the name of the playlist, the number of likes of the playlist, whether the playlist is public or private, and when the playlist was created and last updated.  The playlist adds table includes the rationale for the addition of each song, and the date the record was created and updated.  The song table includes the title, length, and number of streams of the song, whether or not the song is explicit, and when the record was created and updated.  The album table includes the title of the album, the release date, and when the record was created and updated.  The artist table includes the artist’s name and genre, and when the record was created and updated.  The enumeration we have chosen consists of the genres, including pop, rock, indie, rap, country, and R&B.
