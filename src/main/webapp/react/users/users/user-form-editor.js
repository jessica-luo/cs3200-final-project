import userService from "./user-service"

const {useParams} = window.ReactRouterDOM;

const {useState, useEffect} = React;

const UserFormEditor = () => {
    const {id} = useParams()
    const [user, setUser] = useState({})
    useEffect(() => {
        if (id !== "new") {
            findUserById(id)
        }
    }, []);

    const findUserById = (id) =>
        userService.findUserById(id).then(user => setUser(user))

    const deleteUser = (id) =>
        userService.deleteUser(id)
            .then(() => history.back())

    const createUser = (user) =>
        userService.createUser(user)
            .then(() => history.back())

    const updateUser = (id, newUser) =>
        userService.updateUser(id, newUser)
            .then(() => history.back())

    return (
        <div>
            <h2>User Editor</h2>
            <label>First Name</label>
            <input
                onChange={(e) =>
                    setUser(user =>
                        ({...user, firstName: e.target.value}))}
                value={user.firstName}/><br/>
            <label>Last Name</label>
            <input
                onChange={(e) =>
                    setUser(user =>
                        ({...user, lastName: e.target.value}))}
                value={user.lastName}/><br/>
            <label>Username</label>
            <input
                onChange={(e) =>
                    setUser(user =>
                        ({...user, username: e.target.value}))}
                value={user.username}/>
            <br/>
            <label>Password</label>
            <input
                onChange={(e) =>
                    setUser(user =>
                        ({...user, password: e.target.value}))}
                value={user.password}/>
            <br/>

            <label>Email</label>
            <input
                onChange={(e) =>
                    setUser(user =>
                        ({...user, email: e.target.value}))}
                value={user.email}/>
            <br/>

            <label>Date of Birth</label>
            <input
                onChange={(e) =>
                    setUser(user =>
                        ({...user, dateOfBirth: e.target.value}))}
                value={user.dateOfBirth}/>
            <br/>

            <br/>
            <button className="btn btn-warning"
                    onClick={() => {
                        history.back()
                    }}>
                Cancel
            </button>
            <button className="btn btn-danger"
                    onClick={() => deleteUser(user.id)}>
                Delete
            </button>

            <button className="btn btn-primary"
                    onClick={() => updateUser(user.id, user)}>
                Save
            </button>

            <button className="btn btn-success"
                    onClick={() => createUser(user)}>
                Create
            </button>

            <br/>
            <h2 className="mt-5">Playlists Associated With This User</h2>
        </div>

    )
}

export default UserFormEditor