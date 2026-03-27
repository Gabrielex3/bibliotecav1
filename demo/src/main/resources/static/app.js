// ==========================================
// A. LÓGICA DE NAVEGACIÓN Y SESIÓN
// ==========================================
const seccionInicio = document.getElementById('seccionInicio');
const seccionLogin = document.getElementById('seccion-login');
const seccionLibros = document.getElementById('seccionLibros');
const seccionPrestamos = document.getElementById('seccionPrestamos');

const btnIrLogin = document.getElementById('btn-ir-login');
const btnCerrarSesion = document.getElementById('btn-cerrar-sesion');
const btnVolverNav = document.getElementById('btn-volver-nav');
const formLogin = document.getElementById('formulario-login');
const msgError = document.getElementById('mensaje-error');

// Función para ocultar todas las secciones
function ocultarTodo() {
    seccionInicio.classList.add('oculta');
    seccionLogin.classList.add('oculta');
    seccionLibros.classList.add('oculta');
    seccionPrestamos.classList.add('oculta');
}

// Ir al Login
btnIrLogin.addEventListener('click', () => {
    ocultarTodo();
    seccionLogin.classList.remove('oculta');
    btnVolverNav.classList.remove('oculta');
    btnIrLogin.classList.add('oculta');
});

// Iniciar Sesión
formLogin.addEventListener('submit', (evento) => {
    evento.preventDefault();
    const usuario = document.getElementById('usuario').value;
    const password = document.getElementById('password').value;

    // Validamos credenciales (puedes cambiar esto luego)
    if (usuario === 'admin' && password === '123') {
        msgError.classList.add('oculta');
        formLogin.reset();

        // Cambiamos botones de nav
        btnCerrarSesion.classList.remove('oculta');

        // Mostramos elementos de administrador
        document.querySelectorAll('.admin-only').forEach(el => el.classList.remove('oculta'));

        // Volvemos al inicio
        document.querySelector('.volverInicio').click();
        alert("¡Sesión iniciada! Ahora tienes permisos de administrador.");
    } else {
        msgError.classList.remove('oculta');
    }
});

// Cerrar Sesión
btnCerrarSesion.addEventListener('click', () => {
    btnCerrarSesion.classList.add('oculta');
    btnIrLogin.classList.remove('oculta');

    // Ocultamos elementos de administrador
    document.querySelectorAll('.admin-only').forEach(el => el.classList.add('oculta'));

    document.querySelector('.volverInicio').click();
    alert("Sesión cerrada.");
});

// Navegación: Botones del Menú Principal
document.getElementById('btnIrLibros').addEventListener('click', () => {
    ocultarTodo();
    seccionLibros.classList.remove('oculta');
    btnVolverNav.classList.remove('oculta');
    document.getElementById('btnVerLibros').click(); // Carga la API
});

document.getElementById('btnIrPrestamos').addEventListener('click', () => {
    ocultarTodo();
    seccionPrestamos.classList.remove('oculta');
    btnVolverNav.classList.remove('oculta');
    document.getElementById('btnVerPrestamos').click(); // Carga la API
});

// Navegación: Volver al Inicio
document.querySelectorAll('.volverInicio').forEach(boton => {
    boton.addEventListener('click', () => {
        ocultarTodo();
        seccionInicio.classList.remove('oculta');
        btnVolverNav.classList.add('oculta');
        if(btnCerrarSesion.classList.contains('oculta')) {
            btnIrLogin.classList.remove('oculta'); // Mostrar login si no hay sesión
        }
        msgError.classList.add('oculta');
    });
});

// ==========================================
// B. LÓGICA DE LA API (Libros)
// ==========================================

document.getElementById('formLibro').addEventListener('submit', function(evento) {
    evento.preventDefault();
    const titulo = document.getElementById('tituloLibro').value;
    const autor = document.getElementById('autorLibro').value;
    const editorial = document.getElementById('editorialLibro').value.trim() !== "" ? document.getElementById('editorialLibro').value : "No especificada";
    const isbn = document.getElementById('isbnLibro').value || "No especificado";
    const anioIngresado = parseInt(document.getElementById('anioLibro').value) || 0;

    fetch('/api/v1/libros')
        .then(res => res.json())
        .then(libros => {
            let siguienteId = 1;
            if (libros.length > 0) {
                siguienteId = Math.max(...libros.map(l => l.id || 0)) + 1;
            }
            const nuevoLibro = { id: siguienteId, isbn: isbn, titulo: titulo, editorial: editorial, fechaPublicacion: anioIngresado, autor: autor };
            return fetch('/api/v1/libros', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(nuevoLibro)
            });
        })
        .then(res => {
            if(res.ok) { alert('¡Libro guardado exitosamente!'); document.getElementById('formLibro').reset(); document.getElementById('btnVerLibros').click(); }
            else { alert('Error al guardar el libro.'); }
        }).catch(err => console.error(err));
});

document.getElementById('btnVerLibros').addEventListener('click', function() {
    fetch('/api/v1/libros')
        .then(res => res.json())
        .then(libros => {
            const contenedor = document.getElementById('contenedorTablaLibros');
            if (libros.length === 0) { contenedor.innerHTML = '<p>No hay libros registrados.</p>'; return; }
            let tablaHTML = `<table><thead><tr><th>ID</th><th>Título</th><th>Autor</th><th>Editorial</th><th>ISBN</th><th>Año Pub.</th></tr></thead><tbody>`;
            libros.forEach(l => {
                const anioMostrar = (l.fechaPublicacion === 0) ? '-' : (l.fechaPublicacion || '-');
                tablaHTML += `<tr><td><strong>${l.id}</strong></td><td>${l.titulo || '-'}</td><td>${l.autor || '-'}</td><td>${l.editorial || '-'}</td><td>${l.isbn || '-'}</td><td>${anioMostrar}</td></tr>`;
            });
            tablaHTML += `</tbody></table>`;
            contenedor.innerHTML = tablaHTML;
        })
        .catch(error => document.getElementById('contenedorTablaLibros').innerHTML = '<p style="color:var(--danger);">Error de conexión. ¿El servidor Java está encendido?</p>');
});

document.getElementById('btnEliminarLibro').addEventListener('click', function() {
    const id = document.getElementById('idEliminarLibro').value;
    if (!id) return;
    if (confirm(`¿Eliminar libro ID ${id}?`)) {
        fetch(`/api/v1/libros/buscador/id/${id}`, { method: 'DELETE' })
            .then(res => {
                if(res.ok) { alert('Eliminado.'); document.getElementById('idEliminarLibro').value = ''; document.getElementById('btnVerLibros').click(); }
                else { alert('Error al eliminar. Verifique el ID.'); }
            }).catch(err => console.error(err));
    }
});

// ==========================================
// C. LÓGICA DE LA API (Préstamos)
// ==========================================

document.getElementById('formPrestamo').addEventListener('submit', function(evento) {
    evento.preventDefault();
    const idLibroInput = parseInt(document.getElementById('idLibroPrestamo').value);
    const runInput = document.getElementById('runSolicitante').value;
    const diasInput = parseInt(document.getElementById('cantidadDias').value);
    const fechaLocalExacta = new Date(new Date().getTime() - (new Date().getTimezoneOffset() * 60000)).toISOString();

    fetch('/api/v1/prestamos')
        .then(res => res.json())
        .then(prestamos => {
            let siguienteId = 1;
            if (prestamos.length > 0) { siguienteId = Math.max(...prestamos.map(p => p.id_prestamo || p.id || 0)) + 1; }
            const nuevoPrestamo = { id_prestamo: siguienteId, id_libro: idLibroInput, run_solicitante: runInput, fecha_solicitud: fechaLocalExacta, fecha_entrega: null, cantidad_dias: diasInput, multas: 0 };
            return fetch('/api/v1/prestamos', { method: 'POST', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify(nuevoPrestamo) });
        })
        .then(res => {
            if(res.ok) { alert('¡Préstamo registrado!'); document.getElementById('formPrestamo').reset(); document.getElementById('btnVerPrestamos').click(); }
            else { alert('Error al guardar el préstamo.'); }
        }).catch(err => console.error(err));
});

document.getElementById('btnVerPrestamos').addEventListener('click', function() {
    fetch('/api/v1/libros')
        .then(res => res.json())
        .then(libros => {
            const mapaLibros = {};
            libros.forEach(l => { mapaLibros[l.id] = l; });
            return fetch('/api/v1/prestamos').then(res => res.json()).then(prestamos => ({ prestamos, mapaLibros }));
        })
        .then(({ prestamos, mapaLibros }) => {
            const contenedor = document.getElementById('contenedorTablaPrestamos');
            if (prestamos.length === 0) { contenedor.innerHTML = '<p>No hay préstamos activos.</p>'; return; }
            let tablaHTML = `<table><thead><tr><th>ID Préstamo</th><th>RUN</th><th>Fecha</th><th>Días</th><th>ID Libro</th><th>Título</th><th>Autor</th></tr></thead><tbody>`;
            prestamos.forEach(p => {
                const libroPrestado = mapaLibros[p.id_libro];
                const titulo = libroPrestado ? libroPrestado.titulo : '-';
                const autor = libroPrestado ? libroPrestado.autor : '-';
                tablaHTML += `<tr><td><strong>${p.id_prestamo || p.id}</strong></td><td>${p.run_solicitante}</td><td>${new Date(p.fecha_solicitud).toLocaleDateString('es-CL')}</td><td>${p.cantidad_dias}</td><td><strong>${p.id_libro}</strong></td><td>${titulo}</td><td>${autor}</td></tr>`;
            });
            tablaHTML += `</tbody></table>`;
            contenedor.innerHTML = tablaHTML;
        }).catch(error => document.getElementById('contenedorTablaPrestamos').innerHTML = '<p style="color:var(--danger);">Error de conexión.</p>');
});

document.getElementById('btnEliminarPrestamo').addEventListener('click', function() {
    const id = document.getElementById('idEliminarPrestamo').value;
    if (!id) return;
    if (confirm(`¿Eliminar préstamo ID ${id}?`)) {
        fetch(`/api/v1/prestamos/${id}`, { method: 'DELETE' })
            .then(res => {
                if(res.ok) { alert('Eliminado.'); document.getElementById('idEliminarPrestamo').value = ''; document.getElementById('btnVerPrestamos').click(); }
                else { alert('Error al eliminar.'); }
            }).catch(err => console.error(err));
    }
});