import artistService from "./artist-service"

const {useState, useEffect} = React;

const {Link, useHistory} = window.ReactRouterDOM;

const ArtistList = () => {
    const history = useHistory()
    const [artists, setArtists] = useState([])
    useEffect(() => {
        findAllArtists()
    }, [])
    const findAllArtists = () =>
        artistService.findAllArtists()
            .then(artists => setArtists(artists))

    function getGenre(genre) {
        if (genre === 1) {
            return "Pop";
        } else if (genre === 2) {
            return "Rock";
        } else if (genre === 3) {
            return "Indie";
        } else if (genre === 4) {
            return "Rap";
        } else if (genre === 5) {
            return "Country";
        } else if (genre === 6) {
            return "R&B";
        }
    }

    return (
        <div>
            <h2>Artist List</h2>

            <button className="btn btn-primary" onClick={() => history.push("/artists/new")}>
                Add Artist
            </button>

            <ul className="list-group">
                {
                    artists.map(artist =>
                        <li className="list-group-item"
                            key={artist.id}>
                            <Link to={`/artists/${artist.id}`}>
                                {artist.id},
                                {artist.name},
                                {getGenre(artist.genre)}
                            </Link>
                        </li>)
                }
            </ul>

        </div>
    )
}

export default ArtistList;