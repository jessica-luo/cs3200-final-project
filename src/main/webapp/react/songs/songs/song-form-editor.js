import InlineSongEditor from "./inline-song-editor";

const {useParams, useHistory} = window.ReactRouterDOM;
import songService from "./song-service"

const {useState, useEffect} = React;

const SongFormEditor = () => {
    const {id} = useParams()
    const [song, setSong] = useState({})
    useEffect(() => {
        if (id !== "new") {
            findSongById(id)
        }
    }, []);

    const findSongById = (id) =>
        songService.findSongById(id).then(song => setSong(song))

    const deleteSong = (id) =>
        songService.deleteSong(id)
            .then(() => history.back())

    const createSong = (song) =>
        songService.createSong(song)
            .then(() => history.back())

    const updateSong = (id, newSong) =>
        songService.updateSong(id, newSong)
            .then(() => history.back())

    return (
        <div>
            <h2>Song Editor</h2>
            <label>Title</label>
            <input
                onChange={(e) =>
                    setSong(song =>
                        ({...song, title: e.target.value}))}
                value={song.title}/><br/>
            <label>Length</label>
            <input
                onChange={(e) =>
                    setSong(song =>
                        ({...song, length: e.target.value}))}
                value={song.length}/><br/>

            <label>Streams</label>
            <input
                onChange={(e) =>
                    setSong(song =>
                        ({...song, streams: e.target.value}))}
                value={song.streams}/><br/>

            <label>Explicit</label>
            <input
                onChange={(e) =>
                    setSong(song =>
                        ({...song, explicit: e.target.value}))}
                value={song.explicit}/><br/>

            <label>Album ID</label>
            <input
                onChange={(e) =>
                    setSong(song =>
                        ({...song, album_id: e.target.value}))}
                value={song.album_id}/><br/>

            <br/>

            <button className="btn btn-warning"
                    onClick={() => {
                        history.back()
                    }}>
                Cancel
            </button>
            <button className="btn btn-danger"
                    onClick={() => deleteSong(song.id)}>
                Delete
            </button>

            <button className="btn btn-primary"
                    onClick={() => updateSong(song.id, song)}>
                Save
            </button>

            <button className="btn btn-success"
                    onClick={() => createSong(song)}>
                Create
            </button>

            <br/>

            <a href={`/cs3200-final-project/src/main/webapp/react/albums/index.html#/albums/${song.album_id}`}>
                Link to Associated Album
            </a>

            <br/>
            <h2 className="mt-5">PlaylistAdds Associated With This Song</h2>

            <InlineSongEditor songId={song.id}/>
        </div>
    )
}

export default SongFormEditor