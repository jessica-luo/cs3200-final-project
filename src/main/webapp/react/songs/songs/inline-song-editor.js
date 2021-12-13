import playlistService, {findAllPlaylistAdds} from "./song-service";
const {useState, useEffect } = React;
const {Link} = window.ReactRouterDOM;

const InlineSongEditor = ({songId}) => {
    const [playlistAdds, setPlaylistAdds] = useState([])
    useEffect(() => {
        findAllPlaylistAdds()
    }, [])
    const findAllPlaylistAdds = () =>
        playlistService.findAllPlaylistAdds()
            .then(playlistAdds => setPlaylistAdds(playlistAdds))

    const filteredPlaylistAdds = playlistAdds.filter(playlistAdd => playlistAdd.song_id === songId)

    return(
        <div>
            <ul className="list-group">
                {
                    filteredPlaylistAdds.map(playlistAdd =>
                        <li className="list-group-item"
                            key={playlistAdd.id}>
                            <a href={`/cs3200-final-project/src/main/webapp/react/playlistadds/index.html#/playlistadds/${playlistAdd.id}`}>
                                {playlistAdd.id},
                                {playlistAdd.rationale},
                                {playlistAdd.song_id},
                                {playlistAdd.playlist_id}
                            </a>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default InlineSongEditor;