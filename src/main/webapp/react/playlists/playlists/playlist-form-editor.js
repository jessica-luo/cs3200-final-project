const {useParams, useHistory} = window.ReactRouterDOM;
import playlistService from "./playlist-service"

const {useState, useEffect} = React;

const PlaylistFormEditor = () => {
    const {id} = useParams()
    const [playlist, setPlaylist] = useState({})
    useEffect(() => {
        if (id !== "new") {
            findPlaylistById(id)
        }
    }, []);

    const findPlaylistById = (id) =>
        playlistService.findPlaylistById(id).then(playlist => setPlaylist(playlist))

    const deletePlaylist = (id) =>
        playlistService.deletePlaylist(id)
            .then(() => history.back())

    const createPlaylist = (playlist) =>
        playlistService.createPlaylist(playlist)
            .then(() => history.back())

    const updatePlaylist = (id, newPlaylist) =>
        playlistService.updatePlaylist(id, newPlaylist)
            .then(() => history.back())

    return (
        <div>
            <h2>Playlist Editor</h2>
            <label>Name</label>
            <input
                onChange={(e) =>
                    setPlaylist(playlist =>
                        ({...playlist, name: e.target.value}))}
                value={playlist.name}/><br/>
            <label>Public</label>
            <input
                onChange={(e) =>
                    setPlaylist(playlist =>
                        ({...playlist, pub: e.target.value}))}
                value={playlist.pub}/><br/>

            <label>Likes</label>
            <input
                onChange={(e) =>
                    setPlaylist(playlist =>
                        ({...playlist, likes: e.target.value}))}
                value={playlist.likes}/><br/>

            <label>User ID</label>
            <input
                onChange={(e) =>
                    setPlaylist(playlist =>
                        ({...playlist, userId: e.target.value}))}
                value={playlist.userId}/><br/>

            <br/>

            <button className="btn btn-warning"
                    onClick={() => {
                        history.back()
                    }}>
                Cancel
            </button>
            <button className="btn btn-danger"
                    onClick={() => deletePlaylist(playlist.id)}>
                Delete
            </button>

            <button className="btn btn-primary"
                    onClick={() => updatePlaylist(playlist.id, playlist)}>
                Save
            </button>

            <button className="btn btn-success"
                    onClick={() => createPlaylist(playlist)}>
                Create
            </button>

        </div>
    )
}

export default PlaylistFormEditor