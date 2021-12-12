// TODO: declare URL where server listens for HTTP requests
const PLAYLISTS_URL = "http://localhost:8080/api/playlists"

// TODO: retrieve all users from the server
export const findAllPlaylists = () =>
    fetch(PLAYLISTS_URL)
        .then(response => response.json())

// TODO: retrieve a single user by their ID
export const findPlaylistById = (id) =>
    fetch(`${PLAYLISTS_URL}/${id}`)
        .then(response => response.json())

// TODO: delete a user by their ID
export const deletePlaylist = (id) =>
    fetch(`${PLAYLISTS_URL}/${id}`, {
        method: "DELETE"
    })

// TODO: create a new user
export const createPlaylist = (playlist) =>
    fetch(PLAYLISTS_URL, {
        method: 'POST',
        body: JSON.stringify(playlist),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())

// TODO: update a user by their ID
export const updatePlaylist = (id, playlist) =>
    fetch(`${PLAYLISTS_URL}/${id}`, {
        method: 'PUT',
        body: JSON.stringify(playlist),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())

// TODO: export all functions as the API to this service
export default {
    findAllPlaylists,
    findPlaylistById,
    deletePlaylist,
    createPlaylist,
    updatePlaylist
}
