import songService, {findAllSongs} from "./song-service"

const {useState, useEffect} = React;

const {Link, useHistory} = window.ReactRouterDOM;

const SongList = () => {
    const history = useHistory()
    const [songs, setSongs] = useState([])
    useEffect(() => {
        findAllSongs()
    }, [])
    const findAllSongs = () =>
        songService.findAllSongs()
            .then(songs => setSongs(songs))

    return (
        <div>
            <h2>Song List</h2>

            <button className="btn btn-primary" onClick={() => history.push("/songs/new")}>
                Add Song
            </button>

            <ul className="list-group">
                {
                    songs.map(song =>
                        <li className="list-group-item"
                            key={song.id}>
                            <Link to={`/songs/${song.id}`}>
                                {song.id},
                                {song.title},
                                {song.length},
                                {song.streams},
                                {song.explicit.toString()},
                                {song.album_id}
                            </Link>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default SongList;