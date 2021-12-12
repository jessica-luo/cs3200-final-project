// TODO: declare URL where server listens for HTTP requests
const ALBUMS_URL = "http://localhost:8080/api/albums"

// TODO: retrieve all Albums from the server
export const findAllAlbums = () =>
    fetch(ALBUMS_URL)
        .then(response => response.json())

// TODO: retrieve a single Album by their ID
export const findAlbumById = (id) =>
    fetch(`${ALBUMS_URL}/${id}`)
        .then(response => response.json())

// TODO: delete a Album by their ID
export const deleteAlbum = (id) =>
    fetch(`${ALBUMS_URL}/${id}`, {
        method: "DELETE"
    })

// TODO: create a new Album
export const createAlbum = (album) =>
    fetch(ALBUMS_URL, {
        method: 'POST',
        body: JSON.stringify(album),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())

// TODO: update a Album by their ID
export const updateAlbum = (id, album) =>
    fetch(`${ALBUMS_URL}/${id}`, {
        method: 'PUT',
        body: JSON.stringify(album),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())

// TODO: export all functions as the API to this service
export default {
    findAllAlbums,
    findAlbumById,
    deleteAlbum,
    createAlbum,
    updateAlbum
}
