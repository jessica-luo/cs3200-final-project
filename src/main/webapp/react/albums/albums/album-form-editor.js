const {useParams, useHistory} = window.ReactRouterDOM;
import albumService from "./album-service"

const {useState, useEffect} = React;

const AlbumFormEditor = () => {
    const {id} = useParams()
    const [album, setAlbum] = useState({})
    useEffect(() => {
        if (id !== "new") {
            findAlbumById(id)
        }
    }, []);

    const findAlbumById = (id) =>
        albumService.findAlbumById(id).then(album => setAlbum(album))

    const deleteAlbum = (id) =>
        albumService.deleteAlbum(id)
            .then(() => history.back())

    const createAlbum = (album) =>
        albumService.createAlbum(album)
            .then(() => history.back())

    const updateAlbum = (id, newAlbum) =>
        albumService.updateAlbum(id, newAlbum)
            .then(() => history.back())

    return (
        <div>
            <h2>Album Editor</h2>
            <label>Title</label>
            <input
                onChange={(e) =>
                    setAlbum(album =>
                        ({...album, title: e.target.value}))}
                value={album.title}/><br/>

            <label>Release Date</label>
            <input
                onChange={(e) =>
                    setAlbum(album =>
                        ({...album, releaseDate: e.target.value}))}
                value={album.releaseDate}/><br/>

            <label>Artist ID</label>
            <input
                onChange={(e) =>
                    setAlbum(album =>
                        ({...album, artistId: e.target.value}))}
                value={album.artistId}/><br/>

            <br/>
            <button className="btn btn-warning"
                    onClick={() => {
                        history.back()
                    }}>
                Cancel
            </button>
            <button className="btn btn-danger"
                    onClick={() => deleteAlbum(album.id)}>
                Delete
            </button>

            <button className="btn btn-primary"
                    onClick={() => updateAlbum(album.id, album)}>
                Save
            </button>

            <button className="btn btn-success"
                    onClick={() => createAlbum(album)}>
                Create
            </button>

            <br/>

            <a href={`/cs3200-final-project/src/main/webapp/react/artists/index.html#/artists/${album.artistId}`}>
                Link to Associated Artist
            </a>

            <br/>
            <h2 className="mt-5">Songs Associated With This Album</h2>

        </div>
    )
}

export default AlbumFormEditor