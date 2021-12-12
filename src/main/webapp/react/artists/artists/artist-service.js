// TODO: declare URL where server listens for HTTP requests
const ALBUMS_URL = "http://localhost:8080/api/artists"

// TODO: retrieve all Artists from the server
export const findAllArtists = () =>
    fetch(ALBUMS_URL)
        .then(response => response.json())

// TODO: retrieve a single Artist by their ID
export const findArtistById = (id) =>
    fetch(`${ALBUMS_URL}/${id}`)
        .then(response => response.json())

// TODO: delete a Artist by their ID
export const deleteArtist = (id) =>
    fetch(`${ALBUMS_URL}/${id}`, {
        method: "DELETE"
    })

// TODO: create a new Artist
export const createArtist = (artist) =>
    fetch(ALBUMS_URL, {
        method: 'POST',
        body: JSON.stringify(artist),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())

// TODO: update a Artist by their ID
export const updateArtist = (id, artist) =>
    fetch(`${ALBUMS_URL}/${id}`, {
        method: 'PUT',
        body: JSON.stringify(artist),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())

// TODO: export all functions as the API to this service
export default {
    findAllArtists,
    findArtistById,
    deleteArtist,
    createArtist,
    updateArtist
}
