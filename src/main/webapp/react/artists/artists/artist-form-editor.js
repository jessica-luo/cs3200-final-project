import InlineArtistEditor from "./inline-artist-editor";

const {useParams, useHistory} = window.ReactRouterDOM;
import artistService from "./artist-service"

const {useState, useEffect} = React;

const ArtistFormEditor = () => {
    const {id} = useParams()
    const [artist, setArtist] = useState({})
    useEffect(() => {
        if (id !== "new") {
            findArtistById(id)
        }
    }, []);

    const findArtistById = (id) =>
        artistService.findArtistById(id).then(artist => setArtist(artist))

    const deleteArtist = (id) =>
        artistService.deleteArtist(id)
            .then(() => history.back())

    const createArtist = (artist) =>
        artistService.createArtist(artist)
            .then(() => history.back())

    const updateArtist = (id, newArtist) =>
        artistService.updateArtist(id, newArtist)
            .then(() => history.back())

    return (
        <div>
            <h2>Artist Editor</h2>
            <label>Name</label>
            <input
                onChange={(e) =>
                    setArtist(artist =>
                        ({...artist, name: e.target.value}))}
                value={artist.name}/><br/>

            <label>Genre</label>
            <input
                onChange={(e) =>
                    setArtist(artist =>
                        ({...artist, genre: e.target.value}))}
                value={artist.genre}/><br/>

            <br/>
            <button className="btn btn-warning"
                    onClick={() => {
                        history.back()
                    }}>
                Cancel
            </button>
            <button className="btn btn-danger"
                    onClick={() => deleteArtist(artist.id)}>
                Delete
            </button>

            <button className="btn btn-primary"
                    onClick={() => updateArtist(artist.id, artist)}>
                Save
            </button>

            <button className="btn btn-success"
                    onClick={() => createArtist(artist)}>
                Create
            </button>

            <br/>
            <h2 className="mt-5">Albums Associated With This Artist</h2>
            <InlineArtistEditor artistId={artist.id}/>
        </div>
    )
}

export default ArtistFormEditor