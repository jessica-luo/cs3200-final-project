import PlaylistList from "./playlists/playlist-list";
import PlaylistFormEditor from "./playlists/playlist-form-editor";
const {HashRouter, Route} = window.ReactRouterDOM; 
const App = () => {
    return (
        <div className="container-fluid">
            <HashRouter>
                <Route path={["/playlists", "/"]} exact={true}>
                    <PlaylistList/>
                </Route>
                <Route path="/playlists/:id" exact={true}>
                    <PlaylistFormEditor/>
                </Route>
            </HashRouter>
        </div>
    );
}

export default App;
