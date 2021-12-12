// TODO: declare URL where server listens for HTTP requests
const ALBUMS_URL = "http://localhost:8080/api/playlistadds"

// TODO: retrieve all PlaylistAdds from the server
export const findAllPlaylistAdds = () =>
    fetch(ALBUMS_URL)
        .then(response => response.json())

// TODO: retrieve a single PlaylistAdd by their ID
export const findPlaylistAddById = (id) =>
    fetch(`${ALBUMS_URL}/${id}`)
        .then(response => response.json())

// TODO: delete a PlaylistAdd by their ID
export const deletePlaylistAdd = (id) =>
    fetch(`${ALBUMS_URL}/${id}`, {
        method: "DELETE"
    })

// TODO: create a new PlaylistAdd
export const createPlaylistAdd = (playlistadd) =>
    fetch(ALBUMS_URL, {
        method: 'POST',
        body: JSON.stringify(playlistadd),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())

// TODO: update a PlaylistAdd by their ID
export const updatePlaylistAdd = (id, playlistadd) =>
    fetch(`${ALBUMS_URL}/${id}`, {
        method: 'PUT',
        body: JSON.stringify(playlistadd),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())

// TODO: export all functions as the API to this service
export default {
    findAllPlaylistAdds,
    findPlaylistAddById,
    deletePlaylistAdd,
    createPlaylistAdd,
    updatePlaylistAdd
}
