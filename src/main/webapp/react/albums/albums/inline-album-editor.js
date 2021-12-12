const {useState, useEffect} = React;
const {Link} = window.ReactRouterDOM;

const InlineAlbumEditor = ({album, deleteAlbum, updateAlbum}) => {
    const [albumCopy, setAlbumCopy] = useState(album)
    const [editing, setEditing] = useState(false)
    return (
        <div>
            {
                editing &&
                <div className="row">
                    <div className="col">
                        <input
                            className="form-control"
                            value={albumCopy.title}
                            onChange={(e) => setAlbumCopy(albumCopy => ({...albumCopy, title: e.target.value}))}/>

                        <input
                            className="form-control"
                            value={albumCopy.releaseDate}
                            onChange={(e) => setAlbumCopy(albumCopy => ({...albumCopy, releaseDate: e.target.value}))}/>

                        <input
                            className="form-control"
                            value={albumCopy.artist_id}
                            onChange={(e) => setAlbumCopy(albumCopy => ({...albumCopy, artist_id: e.target.value}))}/>
                    </div>
                    <div className="col-2">
                        <i className="fas fa-2x fa-check float-right margin-left-10px"
                           onClick={() => {
                               setEditing(false)
                               updateAlbum(albumCopy.id, albumCopy)
                           }}/>

                        <i className="fas fa-2x fa-check float-right margin-left-10px"
                           onClick={() => {
                               setEditing(false)
                               updateAlbum(albumCopy.title, albumCopy)
                           }}/>

                        <i className="fas fa-2x fa-check float-right margin-left-10px"
                           onClick={() => {
                               setEditing(false)
                               updateAlbum(albumCopy.releaseDate, albumCopy)
                           }}/>

                        <i className="fas fa-2x fa-check float-right margin-left-10px"
                           onClick={() => {
                               setEditing(false)
                               updateAlbum(albumCopy.artist_id, albumCopy)
                           }}/>

                        <i className="fas fa-2x fa-undo float-right margin-left-10px"
                           onClick={() => setEditing(false)}></i>
                        <i className="fas fa-2x fa-trash float-right margin-left-10px"
                           onClick={() => deleteAlbum(album.id)}></i>
                    </div>
                </div>
            }
            {
                !editing &&
                <div className="row">
                    <div className="col">
                        <Link to={`/albums/${albumCopy.id}`}>
                            {albumCopy.title}
                        </Link>
                    </div>

                    <div className="col">
                        <Link to={`/albums/${albumCopy.id}`}>
                            {albumCopy.release}
                        </Link>
                    </div>

                    <div className="col">
                        <Link to={`/albums/${albumCopy.id}`}>
                            {albumCopy.artist_id}
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

export default InlineAlbumEditor;