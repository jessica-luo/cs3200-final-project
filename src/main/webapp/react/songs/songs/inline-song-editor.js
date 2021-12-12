const {useState, useEffect } = React;
const {Link} = window.ReactRouterDOM;

const InlineSongEditor = ({song, deleteSong, updateSong}) => {
    const [songCopy, setSongCopy] = useState(song)
    const [editing, setEditing] = useState(false)
    return(
        <div>
            {
                editing &&
                <div className="row">
                    <div className="col">
                        <input
                            className="form-control"
                            value={songCopy.title}
                            onChange={(e)=>setSongCopy(songCopy => ({...songCopy, title: e.target.value}))}/>
                    </div>
                    <div className="col">
                        <input
                            className="form-control"
                            value={songCopy.length}
                            onChange={(e)=>setSongCopy(songCopy => ({...songCopy, length: e.target.value}))}/>
                    </div>
                    <div className="col">
                        <input
                            className="form-control"
                            value={songCopy.streams}
                            onChange={(e)=>setSongCopy(songCopy => ({...songCopy, streams: e.target.value}))}/>
                    </div>

                    <div className="col">
                        <input
                            className="form-control"
                            value={songCopy.explicit}
                            onChange={(e)=>setSongCopy(songCopy => ({...songCopy, explicit: e.target.value}))}/>
                    </div>

                    <div className="col">
                        <input
                            className="form-control"
                            value={songCopy.album_id}
                            onChange={(e)=>setSongCopy(songCopy => ({...songCopy, album_id: e.target.value}))}/>
                    </div>

                    <div className="col-1">
                        <Link to={`/songs/${songCopy.id}/blogs`}>
                            Blogs
                        </Link>
                    </div>
                    <div className="col-2">
                        <i className="fas fa-2x fa-check float-right margin-left-10px"
                           onClick={() => {
                               setEditing(false)
                               updateSong(songCopy.id, songCopy)
                           }}></i>
                        <i className="fas fa-2x fa-undo float-right margin-left-10px"
                           onClick={() => setEditing(false)}></i>
                        <i className="fas fa-2x fa-trash float-right margin-left-10px"
                           onClick={() => deleteSong(song.id)}></i>
                    </div>
                </div>
            }
            {
                !editing &&
                <div className="row">
                    <div className="col">
                        <Link to={`/songs/${songCopy.id}`}>
                            {songCopy.title}
                        </Link>
                    </div>
                    <div className="col">
                        <Link to={`/songs/${songCopy.id}`}>
                            {songCopy.length}
                        </Link>
                    </div>
                    <div className="col">
                        <Link to={`/songs/${songCopy.id}`}>
                            {songCopy.streams}
                        </Link>
                    </div>

                    <div className="col">
                        <Link to={`/songs/${songCopy.id}`}>
                            {songCopy.explicit}
                        </Link>
                    </div>

                    <div className="col">
                        <Link to={`/songs/${songCopy.id}`}>
                            {songCopy.album_id}
                        </Link>
                    </div>

                    <div className="col-1">
                        <Link to={`/songs/${songCopy.id}/blogs`}>
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

export default InlineSongEditor;