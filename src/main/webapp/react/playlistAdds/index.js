import PlaylistAddList from "./playlistAdds/playlistadd-list";
import PlaylistAddFormEditor from "./playlistAdds/playlistadd-form-editor";

const {HashRouter, Route} = window.ReactRouterDOM;
const App = () => {
    return (
        <div className="container-fluid">
            <HashRouter>
                <Route path={["/playlistadds", "/"]} exact={true}>
                    <PlaylistAddList/>
                </Route>
                <Route path="/playlistadds/:id" exact={true}>
                    <PlaylistAddFormEditor/>
                </Route>
            </HashRouter>
        </div>
    );
}

export default App;
