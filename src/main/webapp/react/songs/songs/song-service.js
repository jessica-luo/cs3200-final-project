// TODO: declare URL where server listens for HTTP requests
const SONGS_URL = "http://localhost:8080/api/songs"

// TODO: retrieve all users from the server
export const findAllSongs = () =>
    fetch(SONGS_URL)
        .then(response => response.json())

// TODO: retrieve a single user by their ID
export const findSongById = (id) =>
    fetch(`${SONGS_URL}/${id}`)
        .then(response => response.json())

// TODO: delete a user by their ID
export const deleteSong = (id) =>
    fetch(`${SONGS_URL}/${id}`, {
        method: "DELETE"
    })

// TODO: create a new user
export const createSong = (song) =>
    fetch(SONGS_URL, {
        method: 'POST',
        body: JSON.stringify(song),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())

// TODO: update a user by their ID
export const updateSong = (id, song) =>
    fetch(`${SONGS_URL}/${id}`, {
        method: 'PUT',
        body: JSON.stringify(song),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())

// TODO: export all functions as the API to this service
export default {
    findAllSongs,
    findSongById,
    deleteSong,
    createSong,
    updateSong
}
