const {useState, useEffect } = React;
const {Link} = window.ReactRouterDOM;

const InlinePlaylistEditor = ({playlist, deletePlaylist, updatePlaylist}) => {
    const [playlistCopy, setPlaylistCopy] = useState(playlist)
    const [editing, setEditing] = useState(false)
    return(
        <div>
            {
                editing &&
                <div className="row">
                    <div className="col">
                        <input
                            className="form-control"
                            value={playlistCopy.name}
                            onChange={(e)=>setPlaylistCopy(playlistCopy => ({...playlistCopy, name: e.target.value}))}/>
                    </div>
                    <div className="col">
                        <input
                            className="form-control"
                            value={playlistCopy.pub}
                            onChange={(e)=>setPlaylistCopy(playlistCopy => ({...playlistCopy, pub: e.target.value}))}/>
                    </div>
                    <div className="col">
                        <input
                            className="form-control"
                            value={playlistCopy.likes}
                            onChange={(e)=>setPlaylistCopy(playlistCopy => ({...playlistCopy, likes: e.target.value}))}/>
                    </div>

                    <div className="col">
                        <input
                            className="form-control"
                            value={playlistCopy.userId}
                            onChange={(e)=>setPlaylistCopy(playlistCopy => ({...playlistCopy, userId: e.target.value}))}/>
                    </div>

                    <div className="col-1">
                        <Link to={`/playlists/${playlistCopy.id}/blogs`}>
                            Blogs
                        </Link>
                    </div>
                    <div className="col-2">
                        <i className="fas fa-2x fa-check float-right margin-left-10px"
                           onClick={() => {
                               setEditing(false)
                               updatePlaylist(playlistCopy.id, playlistCopy)
                           }}></i>
                        <i className="fas fa-2x fa-undo float-right margin-left-10px"
                           onClick={() => setEditing(false)}></i>
                        <i className="fas fa-2x fa-trash float-right margin-left-10px"
                           onClick={() => deletePlaylist(playlist.id)}></i>
                    </div>
                </div>
            }
            {
                !editing &&
                <div className="row">
                    <div className="col">
                        <Link to={`/playlists/${playlistCopy.id}`}>
                            {playlistCopy.name}
                        </Link>
                    </div>
                    <div className="col">
                        <Link to={`/playlists/${playlistCopy.id}`}>
                            {playlistCopy.pub}
                        </Link>
                    </div>
                    <div className="col">
                        <Link to={`/playlists/${playlistCopy.id}`}>
                            {playlistCopy.likes}
                        </Link>
                    </div>

                    <div className="col">
                        <Link to={`/playlists/${playlistCopy.id}`}>
                            {playlistCopy.userId}
                        </Link>
                    </div>

                    <div className="col-1">
                        <Link to={`/playlists/${playlistCopy.id}/blogs`}>
                            Blogs
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

export default InlinePlaylistEditor;