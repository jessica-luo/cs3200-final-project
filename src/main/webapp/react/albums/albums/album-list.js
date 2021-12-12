import albumService from "./album-service"

const {useState, useEffect} = React;

const {Link, useHistory} = window.ReactRouterDOM;

const AlbumList = () => {
    const history = useHistory()
    const [albums, setAlbums] = useState([])
    useEffect(() => {
        findAllAlbums()
    }, [])
    const findAllAlbums = () =>
        albumService.findAllAlbums()
            .then(albums => setAlbums(albums))

    return (
        <div>
            <h2>Album List</h2>

            <button className="btn btn-primary" onClick={() => history.push("/albums/new")}>
                Add Album
            </button>

            <ul className="list-group">
                {
                    albums.map(album =>
                        <li className="list-group-item"
                            key={album.id}>
                            <Link to={`/albums/${album.id}`}>
                                {album.id},
                                {album.title},
                                {album.releaseDate},
                                {album.artistId}
                            </Link>
                        </li>)
                }
            </ul>

        </div>
    )
}

export default AlbumList;