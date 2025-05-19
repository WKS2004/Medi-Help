// Toggle each filter section (both desktop and mobile)
document.querySelectorAll("button[aria-controls^='filter-section']").forEach((btn) => {
    btn.addEventListener("click", () => {
        const targetId = btn.getAttribute("aria-controls");
        const section = document.getElementById(targetId);
        const expanded = btn.getAttribute("aria-expanded") === "true";

        // Toggle aria-expanded
        btn.setAttribute("aria-expanded", !expanded);

        // Toggle visibility of section
        if (!expanded) {
            section.classList.remove("hidden");
        } else {
            section.classList.add("hidden");
        }
    });
});

const openFilterBtn = document.getElementById("openMobileFilter")
const closeFilterBtn = document.querySelector("#mobileFilterPanel button");

const filterOverlay = document.getElementById("mobileFilterOverlay");
const filterPanel = document.getElementById("mobileFilterPanel");

// Open filter panel
openFilterBtn?.addEventListener("click", () => {
    filterOverlay.classList.remove("hidden");
    filterPanel.classList.remove("hidden", "translate-x-full");
    filterPanel.classList.add("translate-x-0");
});

// Close filter panel
closeFilterBtn?.addEventListener("click", () => {
    filterPanel.classList.add("translate-x-full");
    filterOverlay.classList.add("hidden");

    // Delay hiding the panel until after the transition
    setTimeout(() => {
        filterPanel.classList.add("hidden");
    }, 300); // Match transition duration
});

// Close on clicking outside (overlay)
filterOverlay?.addEventListener("click", () => {
    closeFilterBtn?.click();
});

const sortButton = document.getElementById("sortButton");
const sortDropdown = document.getElementById("sortDropdown");

// Toggle dropdown on button click
sortButton?.addEventListener("click", (e) => {
    e.stopPropagation(); // Prevent click from bubbling up
    sortDropdown.classList.toggle("hidden");
});

// Hide dropdown when clicking outside
document.addEventListener("click", (e) => {
    if (!sortDropdown.contains(e.target) && !sortButton.contains(e.target)) {
        sortDropdown.classList.add("hidden");
    }
});

document.querySelectorAll(".filter-toggle-button").forEach(button => {
    button.addEventListener("click", () => {
        const targetId = button.getAttribute("data-target");
        const section = document.getElementById(targetId);
        const plusIcon = document.getElementById(`icon-plus-${targetId}`);
        const minusIcon = document.getElementById(`icon-minus-${targetId}`);

        const isHidden = section.classList.contains("hidden");

        if (isHidden) {
            section.classList.remove("hidden");
            plusIcon.classList.add("hidden");
            minusIcon.classList.remove("hidden");
        } else {
            section.classList.add("hidden");
            plusIcon.classList.remove("hidden");
            minusIcon.classList.add("hidden");
        }
    });
});