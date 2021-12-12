const {useState, useEffect} = React;
const {Link} = window.ReactRouterDOM;

const InlineArtistEditor = ({artist, deleteArtist, updateArtist}) => {
    const [artistCopy, setArtistCopy] = useState(artist)
    const [editing, setEditing] = useState(false)
    return (
        <div>
            {
                editing &&
                <div className="row">
                    <div className="col">
                        <input
                            className="form-control"
                            value={artistCopy.name}
                            onChange={(e) => setArtistCopy(artistCopy => ({...artistCopy, title: e.target.value}))}/>

                        <input
                            className="form-control"
                            value={artistCopy.genre}
                            onChange={(e) => setArtistCopy(artistCopy => ({...artistCopy, releaseDate: e.target.value}))}/>

                    </div>
                    <div className="col-2">
                        <i className="fas fa-2x fa-check float-right margin-left-10px"
                           onClick={() => {
                               setEditing(false)
                               updateArtist(artistCopy.id, artistCopy)
                           }}/>

                        <i className="fas fa-2x fa-check float-right margin-left-10px"
                           onClick={() => {
                               setEditing(false)
                               updateArtist(artistCopy.name, artistCopy)
                           }}/>

                        <i className="fas fa-2x fa-check float-right margin-left-10px"
                           onClick={() => {
                               setEditing(false)
                               updateArtist(artistCopy.genre, artistCopy)
                           }}/>


                        <i className="fas fa-2x fa-undo float-right margin-left-10px"
                           onClick={() => setEditing(false)}></i>
                        <i className="fas fa-2x fa-trash float-right margin-left-10px"
                           onClick={() => deleteArtist(artist.id)}></i>
                    </div>
                </div>
            }
            {
                !editing &&
                <div className="row">
                    <div className="col">
                        <Link to={`/artists/${artistCopy.id}`}>
                            {artistCopy.name}
                        </Link>
                    </div>

                    <div className="col">
                        <Link to={`/artists/${artistCopy.id}`}>
                            {artistCopy.genre}
                        </Link>
                    </div>

                    <div className="col-2">
                        <i className="fas fa-cog fa-2x float-right"
                           onClick={() => setEditing(true)}></i>
                    </div>
                </div>
            }
        </div>
    )
}

export default InlineArtistEditor;