const {useParams, useHistory} = window.ReactRouterDOM;
import playlistaddService from "./playlistadd-service"

const {useState, useEffect} = React;

const PlaylistaddFormEditor = () => {
    const {id} = useParams()
    const [playlistadd, setPlaylistAdd] = useState({})
    useEffect(() => {
        if (id !== "new") {
            findPlaylistAddById(id)
        }
    }, []);

    const findPlaylistAddById = (id) =>
        playlistaddService.findPlaylistAddById(id).then(playlistadd => setPlaylistAdd(playlistadd))

    const deletePlaylistAdd = (id) =>
        playlistaddService.deletePlaylistAdd(id)
            .then(() => history.back())

    const createPlaylistAdd = (playlistadd) =>
        playlistaddService.createPlaylistAdd(playlistadd)
            .then(() => history.back())

    const updatePlaylistAdd = (id, newPlaylistAdd) =>
        playlistaddService.updatePlaylistAdd(id, newPlaylistAdd)
            .then(() => history.back())

    return (
        <div>
            <h2>PlaylistAdd Editor</h2>
            <label>Rationale</label>
            <input
                onChange={(e) =>
                    setPlaylistAdd(playlistadd =>
                        ({...playlistadd, rationale: e.target.value}))}
                value={playlistadd.rationale}/><br/>

            <label>Song ID</label>
            <input
                onChange={(e) =>
                    setPlaylistAdd(playlistadd =>
                        ({...playlistadd, song_id: e.target.value}))}
                value={playlistadd.song_id}/><br/>

            <label>Playlist ID</label>
            <input
                onChange={(e) =>
                    setPlaylistAdd(playlistadd =>
                        ({...playlistadd, playlist_id: e.target.value}))}
                value={playlistadd.playlist_id}/><br/>

            <br/>
            <button className="btn btn-warning"
                    onClick={() => {
                        history.back()
                    }}>
                Cancel
            </button>
            <button className="btn btn-danger"
                    onClick={() => deletePlaylistAdd(playlistadd.id)}>
                Delete
            </button>

            <button className="btn btn-primary"
                    onClick={() => updatePlaylistAdd(playlistadd.id, playlistadd)}>
                Save
            </button>

            <button className="btn btn-success"
                    onClick={() => createPlaylistAdd(playlistadd)}>
                Create
            </button>

        </div>
    )
}

export default PlaylistaddFormEditor