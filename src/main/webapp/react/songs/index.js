import SongList from "./songs/song-list";
import SongFormEditor from "./songs/song-form-editor";
const {HashRouter, Route} = window.ReactRouterDOM; 
const App = () => {
    return (
        <div className="container-fluid">
            <HashRouter>
                <Route path={["/songs", "/"]} exact={true}>
                    <SongList/>
                </Route>
                <Route path="/songs/:id" exact={true}>
                    <SongFormEditor/>
                </Route>
            </HashRouter>
        </div>
    );
}

export default App;
