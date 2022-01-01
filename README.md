# CS3200 Fall 2021 Final Project
## Group 17, December 14, 2021
### Ananda Francis, Hannah Lauterwasser, Jessica Luo, and Kelly Ward

### Source Code
https://github.com/jannunzi/db-design-orm-assignment

### UML
<img width="664" alt="Screen Shot 2021-12-05 at 10 36 36 PM" src="https://user-images.githubusercontent.com/82342205/145726177-0719a4ce-c62c-46d1-8a6a-e096402a253f.png">

### Problem Statement
Our group sought to solve the problem of creating and maintaining meaningful playlists.  We realized through our own use of music streaming platforms that we do not always have a clear reasoning as to why we add certain songs to our playlists.  We thought that this could be an interesting feature to include, as it could help the user make more thoughtful decisions when creating playlists and help keep playlists consistent to specific themes. This feature would also allow the user to look back on their playlists and song choices to understand why they have curated a playlist a certain way, which can help when adding more songs to each playlist.  Our group also wanted to ensure that the playlists created included as much information about the songs added as possible, such as the album the song is from and the artist who created it, to help the user keep track of their music.

### Solution Statement
Through this project, we have created a database to keep track of a user’s playlists.  Our problem, which was wanting the user to have the ability to input a reason for each song addition to a playlist, was solved through the use of a PlaylistAdds table.  PlaylistAdds includes the rationale as to why a user added a particular song to a certain playlist, the song being added and what playlist it is being added to.    

### User
The typical user that would benefit from our solution is any user of Spotify, Apple Music, or other music streaming platforms.  This user may find they prefer a system/platform that allows them to have a more organized and intentional approach to adding songs to a playlist. They can match rationales of other playlist adds to make sure every song they’re adding to a specific playlist is consistent with the other playlist adds. For example, if a user is creating a playlist to play for a group of friends, they might want to include songs their friends enjoy, and each song addition could have the rationale of their friend’s name.  This ensures that the playlist would cater to everyone’s music taste and they could easily recall why a specific song was added (maybe a friend leaves the friend group so they want to easily remove all the songs associated with that friend).  The user might also want to add songs throughout certain parts of their year (such as during birthdays, holidays, and more), and the rationale will allow them to remember the songs that were played during that specific memory, providing the user with a playlist to look back on.   

### Domain Objects
The domain objects we have included are playlists, songs, playlistAdds, albums, artists and users.  The playlists table includes information such as the name of the playlist, the number of likes on the playlist, whether the playlist is public or private, and when the playlist was created and last updated. The playlistAdds table includes the rationale for the addition of each song, what song is being added, what playlist it is being added to and the date the addition was created and updated. The songs table includes the title, length, and number of streams of the song, whether or not the song is explicit, and when the record of that song was created and updated in the database. The albums table includes the title of the album, the release date, the artist of the album and when the record of the album was created and updated in the database. The artists table includes the artist’s name and genre, and when the record of that artist was created and updated in the database.  The enumeration we have chosen consists of the genres, including pop, rock, indie, rap, country, and R&B.  The users table includes the user’s first name, last name, username, password email, date of birth and the date the user joined the platform. 
