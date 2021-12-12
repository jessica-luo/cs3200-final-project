import playlistAddService from "./playlistadd-service"

const {useState, useEffect} = React;

const {Link, useHistory} = window.ReactRouterDOM;

const PlaylistaddList = () => {
    const history = useHistory()
    const [playlistAdds, setPlaylistAdds] = useState([])
    useEffect(() => {
        findAllPlaylistAdds()
    }, [])
    const findAllPlaylistAdds = () =>
        playlistAddService.findAllPlaylistAdds()
            .then(playlistAdds => setPlaylistAdds(playlistAdds))

    return (
        <div>
            <h2>PlaylistAdd List</h2>

            <button className="btn btn-primary" onClick={() => history.push("/playlistAdds/new")}>
                Add PlaylistAdd
            </button>

            <ul className="list-group">
                {
                    playlistAdds.map(playlistAdd =>
                        <li className="list-group-item"
                            key={playlistAdd.id}>
                            <Link to={`/playlistAdds/${playlistAdd.id}`}>
                                {playlistAdd.id},
                                {playlistAdd.rationale},
                                {playlistAdd.song_id},
                                {playlistAdd.playlist_id}
                            </Link>
                        </li>)
                }
            </ul>

        </div>
    )
}

export default PlaylistaddList;