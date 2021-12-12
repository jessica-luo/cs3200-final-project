import PlaylistList from "../../playlists/playlists/playlist-list";

const {useState, useEffect} = React;
import songService, {findAllPlaylists, findAllSongs} from "../../songs/songs/song-service";
import userService from "./user-service";

const {Link, useHistory} = window.ReactRouterDOM;

const InlineUserEditor = ({userId}) => {

    const history = useHistory()
    const [playlists, setPlaylists] = useState([])
    useEffect(() => {
        findAllPlaylists()
    }, [])
    const findAllPlaylists = () =>
        userService.findAllPlaylists()
            .then(users => setPlaylists(users))

    const filteredPlaylists = playlists.filter(playlist => playlist.userId === userId)
    return (
        <div>
            <ul className="list-group">
                {
                    filteredPlaylists.map(playlist =>
                        <li className="list-group-item"
                            key={playlist.id}>
                            <a href={`/cs3200-final-project/src/main/webapp/react/playlists/index.html#/playlists/${playlist.id}`}>
                                {playlist.id},
                                {playlist.name},
                                {playlist.likes},
                                {playlist.pub.toString()},
                                {playlist.userId}
                            </a>
                        </li>)
                }
            </ul>
        </div>
    )
}

export default InlineUserEditor;