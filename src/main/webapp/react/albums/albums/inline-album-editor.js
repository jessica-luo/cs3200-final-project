const {useState, useEffect} = React;
const {Link} = window.ReactRouterDOM;

import albumService, {findAllSongs} from "./album-service";

const InlineAlbumEditor = ({albumId}) => {
    const [songs, setSongs] = useState([])
    useEffect(() => {
        findAllSongs()
    }, [])
    const findAllSongs = () =>
        albumService.findAllSongs()
            .then(songs => setSongs(songs))
    const filteredSongs = songs.filter(song => song.album_id === albumId)


    return (
        <div>
            <ul className="list-group">
                {
                    filteredSongs.map(song =>
                        <li className="list-group-item"
                            key={song.id}>
                            <a href={`/cs3200-final-project/src/main/webapp/react/songs/index.html#/songs/${song.id}`}>
                                {song.id},
                                {song.title},
                                {song.length},
                                {song.streams},
                                {song.explicit.toString()},
                                {song.album_id}
                            </a>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default InlineAlbumEditor;