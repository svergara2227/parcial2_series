// Configuración inicial
const API_BASE_URL = 'http://localhost:8080';

// Funciones de utilidad
async function fetchData(endpoint) {
    try {
        const response = await fetch(`${API_BASE_URL}${endpoint}`);
        if (!response.ok) throw new Error('Network response was not ok');
        return await response.json();
    } catch (error) {
        console.error('Error fetching data:', error);
        return null;
    }
}

// Cargar información de la serie
async function loadSerieInfo() {
    const serie = await fetchData('/series/1'); // Asumiendo que The Mandalorian es la serie con ID 1
    if (serie) {
        document.getElementById('serie-poster').src = serie.imagenPoster;
        document.getElementById('serie-titulo').textContent = serie.nombre;
        document.getElementById('serie-creador').textContent = `Creador: ${serie.creador}`;
        document.getElementById('serie-clasificacion').textContent = `Clasificación: ${serie.clasificacion}`;
        document.getElementById('serie-descripcion').textContent = serie.descripcion;
        document.getElementById('serie-anio').textContent = serie.anioEmision;
        document.getElementById('serie-temporadas').textContent = serie.numeroTemporadas;
    }
}

// Cargar temporadas
async function loadTemporadas() {
    const temporadas = await fetchData('/temporadas');
    const container = document.getElementById('temporadas-container');
    container.innerHTML = '';

    temporadas?.forEach(temporada => {
        const temporadaElement = document.createElement('div');
        temporadaElement.className = 'card bg-gray-800 p-4 rounded-lg shadow-lg';
        temporadaElement.innerHTML = `
            <h3 class="text-xl font-bold mb-2">Temporada ${temporada.numeroTemporada}</h3>
            <p>Año: ${temporada.anioLanzamiento}</p>
            <button 
                onclick="loadCapitulos(${temporada.id})"
                class="mt-4 bg-blue-600 hover:bg-blue-700 px-4 py-2 rounded-lg"
            >
                Ver capítulos
            </button>
        `;
        container.appendChild(temporadaElement);
    });
}

// Cargar capítulos de una temporada
async function loadCapitulos(temporadaId) {
    const capitulos = await fetchData(`/temporadas/${temporadaId}/capitulos`);
    const container = document.getElementById('capitulos-container');
    document.getElementById('capitulos').classList.remove('hidden');
    container.innerHTML = '';

    capitulos?.forEach(capitulo => {
        const capituloElement = document.createElement('div');
        capituloElement.className = 'card bg-gray-800 p-4 rounded-lg shadow-lg';
        capituloElement.innerHTML = `
            <h4 class="text-lg font-bold mb-2">Episodio ${capitulo.numeroCapitulo}: ${capitulo.nombre}</h4>
            <p class="text-gray-300 mb-4">${capitulo.descripcion}</p>
            <div class="star-rating" data-capitulo-id="${capitulo.id}">
                ${generateStarRating(capitulo.calificacionPromedio)}
            </div>
        `;
        container.appendChild(capituloElement);
    });
}

// Generar calificación por estrellas
function generateStarRating(rating) {
    let stars = '';
    for (let i = 1; i <= 5; i++) {
        stars += `<span class="star ${i <= rating ? 'filled' : ''}" data-value="${i}">★</span>`;
    }
    return stars;
}

// Cargar personajes
async function loadPersonajes() {
    const personajes = await fetchData('/personajes');
    const container = document.getElementById('personajes-container');
    container.innerHTML = '';

    personajes?.forEach(personaje => {
        const personajeElement = document.createElement('div');
        personajeElement.className = 'card bg-gray-800 p-4 rounded-lg shadow-lg';
        personajeElement.innerHTML = `
            <img src="${personaje.foto}" alt="${personaje.nombre}" class="character-image rounded-lg mb-4">
            <h4 class="text-lg font-bold mb-2">${personaje.nombre}</h4>
            <p class="text-gray-300">${personaje.descripcion}</p>
        `;
        container.appendChild(personajeElement);
    });
}

// Inicialización
document.addEventListener('DOMContentLoaded', () => {
    loadSerieInfo();
    loadTemporadas();
    loadPersonajes();
});