const slides_set1 = document.querySelectorAll('.hero-slide-1');
let currentSlide1 = 0;

function showSlide2(index) {
    slides_set1.forEach((slide, i) => {
        slide.classList.remove('opacity-100', 'z-10');
        slide.classList.add('opacity-0', 'z-0');
    });

    slides_set1[index].classList.remove('opacity-0', 'z-0');
    slides_set1[index].classList.add('opacity-100', 'z-10');
}

function changeHeroSlide2(direction) {
    currentSlide1 = (currentSlide1 + direction + slides_set1.length) % slides_set1.length;
    showSlide2(currentSlide1);
}

// Autoplay every 7 seconds
setInterval(() => {
    changeHeroSlide2(1);
}, 7000);


const slides_set2 = document.querySelectorAll('.hero-slide-2');
let currentSlide2 = 0;

let heroSlider_2_slide1 = document.getElementById('heroSlider-2-slide1');
let heroSlider_2_slide2 = document.getElementById('heroSlider-2-slide2');
let heroSlider_2_controller = [heroSlider_2_slide1, heroSlider_2_slide2];

function showSlide1(index) {

    slides_set2.forEach((slide, i) => {
        slide.classList.remove('opacity-100', 'z-10');
        slide.classList.add('opacity-0', 'z-0');
    });

    slides_set2[index].classList.remove('opacity-0', 'z-0');
    slides_set2[index].classList.add('opacity-100', 'z-10');
    currentSlide2 = index;

    heroSlider_2_controller.forEach((controlButton, i) => {
        controlButton.classList.remove('bg-indigo-400');
        controlButton.classList.add('bg-gray-400')
    })

    heroSlider_2_controller[index].classList.remove('bg-gray-400');
    heroSlider_2_controller[index].classList.add('bg-indigo-400');
}

// Optional: Autoplay every 7 seconds
setInterval(() => {
    currentSlide2 = (currentSlide2 + 1) % slides_set2.length;
    showSlide1(currentSlide2);
}, 7000);


let categoryIndex1 = 0;
const track1 = document.getElementById("categorySliderTrack-1");
const slides1 = document.querySelectorAll(".category-slide-1");

function getVisibleSlides() {
    if (window.innerWidth >= 1024) return 4; // lg
    if (window.innerWidth >= 768) return 3; // md
    if (window.innerWidth >= 640) return 2; // sm
    return 1;
}

function updateSlider1() {
    const slideWidth = slides1[0].offsetWidth;
    const visibleSlides = getVisibleSlides();
    const totalSlides = slides1.length;

    // Normalize index to loop
    if (categoryIndex1 < 0) {
        categoryIndex1 = totalSlides - visibleSlides;
    } else if (categoryIndex1 > totalSlides - visibleSlides) {
        categoryIndex1 = 0;
    }

    const offset = categoryIndex1 * slideWidth;
    track1.style.transform = `translateX(-${offset}px)`;
}

function prevCategorySlide1() {
    categoryIndex1--;
    updateSlider1();
}

function nextCategorySlide1() {
    categoryIndex1++;
    updateSlider1();
}

// Resize handler to recalculate on screen changes
window.addEventListener("resize", updateSlider1);
window.addEventListener("load", updateSlider1);

let categoryIndex2 = 0;
const track2 = document.getElementById("categorySliderTrack-2");
const slides2 = document.querySelectorAll(".category-slide-2");

function updateSlider2() {
    const slideWidth = slides2[0].offsetWidth;
    const visibleSlides = getVisibleSlides();
    const totalSlides = slides2.length;

    // Normalize index to loop
    if (categoryIndex2 < 0) {
        categoryIndex2 = totalSlides - visibleSlides;
    } else if (categoryIndex2 > totalSlides - visibleSlides) {
        categoryIndex2 = 0;
    }

    const offset = categoryIndex2 * slideWidth;
    track2.style.transform = `translateX(-${offset}px)`;
}

function prevCategorySlide2() {
    categoryIndex2--;
    updateSlider2();
}

function nextCategorySlide2() {
    categoryIndex2++;
    updateSlider2();
}

// Resize handler to recalculate on screen changes
window.addEventListener("resize", updateSlider2);
window.addEventListener("load", updateSlider2);
