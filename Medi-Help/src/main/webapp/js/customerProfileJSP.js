function toggleMenu(menuId) {
    const menu = document.getElementById(menuId);
    const arrow = document.getElementById('arrow-' + menuId);

    if (menu.classList.contains('h-0')) {
        menu.classList.remove('h-0');
        arrow.classList.remove('-rotate-90');
    } else {
        menu.classList.add('h-0');
        arrow.classList.add('-rotate-90');
    }
}