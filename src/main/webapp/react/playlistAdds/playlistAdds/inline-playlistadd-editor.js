const {useState, useEffect} = React;
const {Link} = window.ReactRouterDOM;

const InlinePlaylistaddEditor = ({playlistadd, deletePlaylistAdd, updatePlaylistAdd}) => {
    const [playlistaddCopy, setPlaylistAddCopy] = useState(playlistadd)
    const [editing, setEditing] = useState(false)
    return (
        <div>
            {
                editing &&
                <div className="row">
                    <div className="col">
                        <input
                            className="form-control"
                            value={playlistaddCopy.rationale}
                            onChange={(e) => setPlaylistAddCopy(playlistaddCopy => ({...playlistaddCopy, rationale: e.target.value}))}/>

                        <input
                            className="form-control"
                            value={playlistaddCopy.song_id}
                            onChange={(e) => setPlaylistAddCopy(playlistaddCopy => ({...playlistaddCopy, song_id: e.target.value}))}/>
                        <input
                            className="form-control"
                            value={playlistaddCopy.playlist_id}
                            onChange={(e) => setPlaylistAddCopy(playlistaddCopy => ({...playlistaddCopy, playlist_id: e.target.value}))}/>

                    </div>
                    <div className="col-2">
                        <i className="fas fa-2x fa-check float-right margin-left-10px"
                           onClick={() => {
                               setEditing(false)
                               updatePlaylistAdd(playlistaddCopy.id, playlistaddCopy)
                           }}/>

                        <i className="fas fa-2x fa-check float-right margin-left-10px"
                           onClick={() => {
                               setEditing(false)
                               updatePlaylistAdd(playlistaddCopy.song_id, playlistaddCopy)
                           }}/>

                        <i className="fas fa-2x fa-check float-right margin-left-10px"
                           onClick={() => {
                               setEditing(false)
                               updatePlaylistAdd(playlistaddCopy.playlist_id, playlistaddCopy)
                           }}/>


                        <i className="fas fa-2x fa-undo float-right margin-left-10px"
                           onClick={() => setEditing(false)}></i>
                        <i className="fas fa-2x fa-trash float-right margin-left-10px"
                           onClick={() => deletePlaylistAdd(playlistadd.id)}></i>
                    </div>
                </div>
            }
            {
                !editing &&
                <div className="row">
                    <div className="col">
                        <Link to={`/playlistadds/${playlistaddCopy.id}`}>
                            {playlistaddCopy.rationale}
                        </Link>
                    </div>

                    <div className="col">
                        <Link to={`/playlistadds/${playlistaddCopy.id}`}>
                            {playlistaddCopy.song_id}
                        </Link>
                    </div>

                    <div className="col">
                        <Link to={`/playlistadds/${playlistaddCopy.id}`}>
                            {playlistaddCopy.playlist_id}
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

export default InlinePlaylistaddEditor;