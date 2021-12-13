import artistService, {findAllAlbums} from "./artist-service";

const {useState, useEffect} = React;
const {Link} = window.ReactRouterDOM;

const InlineArtistEditor = ({artistId}) => {
    const [albums, setAlbums] = useState([])
    useEffect(() => {
        findAllAlbums()
    }, [])
    const findAllAlbums = () =>
        artistService.findAllAlbums()
            .then(albums => setAlbums(albums))

    const filteredAlbums = albums.filter(album => album.artistId === artistId)

    return (
        <div>
            <ul className="list-group">
                {
                    filteredAlbums.map(album =>
                        <li className="list-group-item"
                            key={album.id}>
                            <a href={`/cs3200-final-project/src/main/webapp/react/albums/index.html#/albums/${album.id}`}>
                                {album.id},
                                {album.title},
                                {album.releaseDate},
                                {album.artistId}
                            </a>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default InlineArtistEditor;