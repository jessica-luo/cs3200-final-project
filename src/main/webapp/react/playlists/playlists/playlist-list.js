import playlistService, {findAllPlaylists} from "./playlist-service"

const {useState, useEffect} = React;

const {Link, useHistory} = window.ReactRouterDOM;

const PlaylistList = () => {
    const history = useHistory()
    const [playlists, setPlaylists] = useState([])
    useEffect(() => {
        findAllPlaylists()
    }, [])
    const findAllPlaylists = () =>
        playlistService.findAllPlaylists()
            .then(playlists => setPlaylists(playlists))

    return (
        <div>
            <h2>Playlist List</h2>

            <button className="btn btn-primary" onClick={() => history.push("/playlists/new")}>
                Add Playlist
            </button>

            <ul className="list-group">
                {
                    playlists.map(playlist =>
                        <li className="list-group-item"
                            key={playlist.id}>
                            <Link to={`/playlists/${playlist.id}`}>
                                {playlist.id},
                                {playlist.name},
                                {playlist.likes},
                                {playlist.pub.toString()},
                                {playlist.userId}
                            </Link>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default PlaylistList;