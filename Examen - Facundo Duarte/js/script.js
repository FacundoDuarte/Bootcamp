const links = document.querySelectorAll('.list__item-link')
const footerLinks = document.querySelectorAll('.footer-list__item-link');
const learnMore = document.getElementById('learnMore');
const buttons = document.querySelectorAll('.btn');

// Con el siguiente evento le doy una interactividad al boton de "More info" haciendo que se vuelva un poco mas grande
buttons.forEach(button => {
    button.addEventListener('mouseenter', () => {
        button.style.transform = 'scale(1.1)';
        button.style.transition = 'all .4s ease';
        button.style.cursor = 'pointer';
    })
    button.addEventListener('mouseleave', () => {
        button.style.transform = 'scale(1)';
        button.style.transition = 'all .4s ease';
    })
})
// Finaliza el evento del boton

// El siguiente evento se dispara cuando se clickea al link de "Learn More" para que muestre una alerta diciendo 'Proximamente...' dando la idea de que pronto estara esa parte disponible
learnMore.addEventListener('click', (e) => {
    e.preventDefault();
    alert('Proximamente...');
})
// Finaliza el evento de "Learn More"

// Los siguientes eventos son para que se muestre activo el navbar
links.forEach(link => {
    link.addEventListener('click', (e) =>{ 
        e.preventDefault();
        links.forEach(link => link.classList.remove('active'));
        link.classList.add('active');
    })
})

footerLinks.forEach(link => {
    link.addEventListener('click', (e) =>{ 
        e.preventDefault();
        footerLinks.forEach(link => link.classList.remove('footer-active'));
        link.classList.add('footer-active');
    })
})
// Finalizan los eventos del navbar