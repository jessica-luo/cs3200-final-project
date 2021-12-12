import AlbumList from "./albums/album-list";
import AlbumFormEditor from "./albums/album-form-editor";
const {HashRouter, Route} = window.ReactRouterDOM; 
const App = () => {
    return (
        <div className="container-fluid">
            <HashRouter>
                <Route path={["/albums", "/"]} exact={true}>
                    <AlbumList/>
                </Route>
                <Route path="/albums/:id" exact={true}>
                    <AlbumFormEditor/>
                </Route>
            </HashRouter>
        </div>
    );
}

export default App;
